export interface Cliente {
    // Usuario (Campos generales de tu UsuarioEntity)
    idUsuario: number;
    nombre: string;
    apellido: string;
    correo: string;
    telefono: string;
    dni: string;
    tipoUsuario: string;
    estadoCuenta?: string;

    // Cliente (Campos específicos de tu ClienteEntity)
    idCliente: number;
    tipoCliente: string;
    fechaCreacion?: string;

    // Dirección (Campos de ubicación plana del Cliente)
    latitud?: number;
    longitud?: number;
}