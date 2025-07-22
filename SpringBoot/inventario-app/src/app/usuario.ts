export interface Usuario {
  idUser?: number;         // opcional porque aún no existe cuando se registra
  userName: string;
  password: string;
  rol: string;         // "ADMIN", "USER"
}
