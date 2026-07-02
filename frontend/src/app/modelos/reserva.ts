export interface Reserva {

  idReserva?: number;

  idCliente: number;

  idNana: number;

  fechaInicio: string;

  fechaFin: string;

  montoTotal: number;

  estadoPago?: string;

  estadoReserva?: string;

  fechaReserva?: string;

}