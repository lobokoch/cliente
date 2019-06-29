/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.889
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

// Angular
import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

// PrimeNG
import { SelectItem } from 'primeng/api';

// Kerubin
import { AuthService } from './../../security/auth.service';
import { UserAccountService } from '../useraccount.service';
import { UserAccount, AccountCreatedDTO } from './useraccount.model';
import { MessageHandlerService } from 'src/app/core/message-handler.service';
import { LogoutService } from 'src/app/security/logout.service';

@Component({
  selector: 'app-newaccount',
  templateUrl: './newaccount.component.html',
  styleUrls: ['./newaccount.component.css']
})
export class NewAccountComponent implements OnInit {

  userAccount = new UserAccount();
  connected = false;
  createdAccountResult = '';
  accountCreated = false;
  btnLabel = 'Criar conta';
  disabled = false;
  touched = false;

  accountTypeSelected: SelectItem;
  accountTypeFieldOptions: SelectItem[];

  constructor(
    private userAccountService: UserAccountService,
    private messageHandler: MessageHandlerService,
    private auth: AuthService,
    private logout: LogoutService,
    private router: Router
  ) { }

  ngOnInit() {
    this.doLoginAnonymous();
    this.accountTypeFieldOptions = [
      { label: 'Conta pessoal, sou pessoa física', value: 'PERSONAL' },
      { label: 'Conta organizacional, sou pessoa jurídica', value: 'CORPORATE' }
    ];
  }

  validateAllFormFields(form: FormGroup) {
    Object.keys(form.controls).forEach(field => {
      const control = form.get(field);
      if (control instanceof FormControl) {
        control.markAsDirty({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }

  createAccount(form: FormGroup) {
    if (!form.valid) {
      this.validateAllFormFields(form);
      return;
    }

    this.disabled = true;
    this.btnLabel = 'Criando a conta, aguarde...';
    this.userAccount.accountType = this.accountTypeSelected.value;
    this.userAccountService.createAccount(this.userAccount)
      .then((response) => {
        this.disabled = false;
        this.btnLabel = 'Conta criada!';
        this.createdAccountResult = response.text;
        this.accountCreated = true;
        this.logout.logout();
      })
      .catch((e) => {
        console.log('Error at createAccount: ' + e);
        this.disabled = false;
        this.btnLabel = 'Erro!';

        if (e.message && (e.message as string).toLowerCase().indexOf('http') === -1) {
          this.createdAccountResult = '<h3>Ocorreu um erro.</h3><p>' + e.message + '</p>';
        } else {
          this.createdAccountResult = '<h3>Ops :(</h3>' +
            '<p>Ocorreu um erro inesperado ao tentar criar a conta. Por favor tente novamente mais tarde.</p>';
        }
        this.accountCreated = true;
        this.logout.logout();
      });
  }

  private doLoginAnonymous() {
    this.auth.doLoginAnonymous()
      .then((result) => {
        console.log('Anonymous connected!');
        this.connected = true;
      })
      .catch((e) => {
        this.connected = false;
        this.messageHandler.showError(e);
      });
  }

  goBack() {
    this.logout.logout()
      .then(() => {
        this.router.navigate(['/mainmenu']);
      })
      .catch(() => {
        this.router.navigate(['/mainmenu']);
      });
  }

}		

