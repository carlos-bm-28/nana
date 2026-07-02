import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import { Router } from '@angular/router';

import { Navbar } from '../../shared/components/navbar/navbar';
import { Footer } from '../../shared/components/footer/footer';

import { NanaService } from '../../servicios/nana';
import { Nana } from '../../modelos/nana';

@Component({
  selector: 'app-registro-nana',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    Navbar,
    Footer
  ],
  templateUrl: './registro-nana.html',
  styleUrl: './registro-nana.css'
})
export class RegistroNana implements OnInit {

  registroForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private nanaService: NanaService
  ) { }

  ngOnInit(): void {

    this.registroForm = this.fb.group({

      // Datos del usuario
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      correo: ['', [Validators.required, Validators.email]],
      telefono: ['', Validators.required],
      dni: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(8)]],
      passwordHash: ['', [Validators.required, Validators.minLength(6)]],
      fechaNacimiento: ['', Validators.required],

      // Datos de la nana
      idUniversidad: ['', Validators.required],
      codigoUniversitario: ['', Validators.required],
      carrera: ['', Validators.required],
      ciclo: ['', Validators.required],
      descripcion: ['', Validators.required],
      experiencia: ['', Validators.required],
      tarifaHora: ['', Validators.required],
      departamento: ['', Validators.required],
      provincia: ['', Validators.required],
      distrito: ['', Validators.required],
      direccion: [''],
      referencia: [''],

      // Valores por defecto
      disponibilidad: ['DISPONIBLE'],
      estadoCuenta: ['ACTIVA'],
      tipoUsuario: ['NANA']

    });

  }

  registrar(): void {

    if (this.registroForm.invalid) {

      alert('Completa todos los campos.');

      return;

    }
    console.log(this.registroForm.value);
    this.nanaService.registrarNana(this.registroForm.value as Nana)
      .subscribe({

        next: (respuesta) => {

          console.log('Registro exitoso', respuesta);

          alert('🎉 Nana registrada correctamente.');

          this.router.navigate(['/login']);

        },

        error: (error) => {

          console.error(error);

          alert('Ocurrió un error al registrar la nana.');

        }

      });

  }

}