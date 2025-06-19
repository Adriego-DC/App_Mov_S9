Resumen General del Proyecto: Aplicación de Confirmación de Asistencia y Notificaciones – San Pedrito UNS


La presente aplicación Android tiene como finalidad principal la gestión de asistencia a eventos universitarios, específicamente a la festividad tradicional de San Pedrito, representando a la Universidad Nacional del Santa (UNS).

Además, ofrece a los alumnos un módulo de notificaciones donde se les informa de eventos importantes, acompañados de una funcionalidad para acceder a información complementaria en línea mediante un WebView.

Funcionalidades principales implementadas:


1. Login y Registro de Usuarios:
Pantallas de Login y Registro desarrolladas con validaciones.

Flujo de navegación asegurado entre Login, Registro y una pantalla de Éxito.

Navegación establecida mediante Navigation Component (NavGraph).

2. Home Personalizado según el rol:
Dos actividades principales:

HomeAlumnoActivity para alumnos.

HomeDocenteActivity para docentes.

Cada Home incluye un BottomNavigationView con acceso a:

Home principal.

Notificaciones.

Perfil del usuario.

3. Módulo de Notificaciones:
Implementación de RecyclerView para listar notificaciones.

Por ahora muestra una única notificación:
“Confirmación de asistencia al desfile”.

Al hacer clic en esta notificación se abre un AlertDialog personalizado con:

Un título descriptivo.

Un texto explicando el evento de San Pedrito.

Un botón de acción: “Confirmar asistencia”, que muestra un Toast y cierra el diálogo.

Un enlace de texto: “¿Desea más información de San Pedrito?”.

4. Navegación desde Dialog a WebView:
Al pulsar el enlace de información se abre una nueva actividad (WebViewActivity) usando un Intent explícito.

Se descartó el uso de NavController en este caso para evitar problemas de navegación y pérdida de contexto en actividades principales como el HomeAlumnoActivity.

El WebView está configurado para permitir la visualización de contenido web correctamente:

Se habilitó JavaScript.

Se carga correctamente la página de Wikipedia sobre San Pedrito:

https://es.wikipedia.org/wiki/Fiesta_patronal_de_San_Pedrito
