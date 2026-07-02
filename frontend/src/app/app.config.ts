import { ApplicationConfig, provideBrowserGlobalErrorListeners, provideZonelessChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes'; // <-- 1. ASEGÚRATE DE QUE SE IMPORTE DE AQUÍ
import { provideClientHydration, withEventReplay } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZonelessChangeDetection(),
    provideRouter(routes), // <-- 2. ESTA FUNCIÓN TIENE QUE TENER 'routes' ADENTRO
    provideClientHydration(withEventReplay()),
    provideHttpClient()
  ]
};
