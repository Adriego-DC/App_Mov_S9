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


Ejecucion de la Aplicacion:

Login:

![WhatsApp Image 2025-06-24 at 17 57 32](https://github.com/user-attachments/assets/1e218e5d-e485-4e13-8098-ea4aa338278d)

Registro:

![WhatsApp Image 2025-06-24 at 17 57 33](https://github.com/user-attachments/assets/dd0c2da0-221d-4db2-8f0e-2fb710a4e1ad)

![WhatsApp Image 2025-06-24 at 18 02 48](https://github.com/user-attachments/assets/1321ee86-b35a-4505-badc-32d8fd87b2e3)

Home:

![WhatsApp Image 2025-06-24 at 17 57 33 (1)](https://github.com/user-attachments/assets/1456c429-c29b-466f-971c-70182a34ebaf)

Perfil:

![WhatsApp Image 2025-06-24 at 17 57 33 (3)](https://github.com/user-attachments/assets/f9323946-5725-42c7-ae59-551ade23f2c6)

Notificaciones:

![WhatsApp Image 2025-06-24 at 17 57 34](https://github.com/user-attachments/assets/7dd043c7-1b5c-4715-8578-fb085a5603ae)

Confirmacion de Asistencia a San Pedritro y Texto con el enlace para abrir una pagina web sobre San Pedrito:

![WhatsApp Image 2025-06-24 at 17 57 34 (2)](https://github.com/user-attachments/assets/c788648a-e69a-4a19-9708-987820b5d581)

![WhatsApp Image 2025-06-24 at 17 57 34 (1)](https://github.com/user-attachments/assets/e502b656-17ae-4621-87b7-e369c616383d)

Enlace de una pagina web para mas informacion de San Pedrito

![WhatsApp Image 2025-06-24 at 17 57 34 (3)](https://github.com/user-attachments/assets/1322c133-2215-4ad7-b3be-49f99684f180)









