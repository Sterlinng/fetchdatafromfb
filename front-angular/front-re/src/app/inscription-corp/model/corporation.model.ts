export class Corporation {
    name: string;
    Siret: string;
    Siren: string;
    mail: string;
    note?: number; // Initialisé à "0" si non spécifié
    address: string;
    phone_number: string;
    ZIP_code: string;
    login: string;
    password: string;


constructor(
    name: string,
    Siret: string,
    Siren: string,
    mail: string,
    note: number = 0, // Initialisé à "0" si non spécifié
    address: string,
    phone_number: string,
    ZIP_code: string,
    login: string,
    password: string,
    ) {
            this.name = name;
            this.Siret = Siret;
            this.Siren = Siren;
            this.note = note;
            this.address = address;
            this.phone_number = phone_number;
            this.ZIP_code = ZIP_code;
            this.login = login;
            this.password = password;
            this.mail = mail;
    }
  }

