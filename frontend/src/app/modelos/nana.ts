export interface Nana {

    // Usuario
    idUsuario: number;
    nombre: string;
    apellido: string;
    correo: string;
    telefono: string;
    dni: string;
    fotoPerfil: string;
    tipoUsuario: string;

    // Nana
    idNana: number;
    idUniversidad: number;
    codigoUniversitario: string;
    carrera: string;
    ciclo: number;
    descripcion: string;
    experiencia: string;
    tarifaHora: number;
    disponibilidad: string;
    verificado: boolean;
    ratingPromedio: number;
    cantidadReviews: number;

    departamento: string;
provincia: string;
distrito: string;
direccion: string;
referencia: string;
    latitud: number;
    longitud: number;

}