JDance
======

Android Application

IDE - Android Studio

###JDance: una aplicación que hace bailar robots 


JDance es una aplicación Android para celular que permite definir ritmos de baile que los robots del proyecto 
“Programando con robots y SL” (http://robots.linti.unlp.edu.ar/) interpretarán. 
El usuario podrá indicarle a los robots que bailen ritmos pre-establecidos o crear ritmos nuevos de baile. 
Desde la aplicación Android, el usuario podrá diseñar nuevas coreografías de baile.

La aplicación se comunica con los robots a través de una aplicación servidora escrita en Python llamada 
RemoteBot. Ambas aplicaciones, cliente Android y servidor RemoteBot, se comunican mediante mensajes 
JSON.

La documentación sobre las primitivas del robot, está disponible en: 
http://robots.linti.unlp.edu.ar/uploads/docs/manual_programando_con_robots.pdf

Videos de actividades realizadas con los robots: 
http://vimeo.com/user12885626/videos 
 
La aplicación servidora está disponible en github: https://github.com/fernandolopez/remotebot
 
La descripción de la aplicación servidora está descripta en: 
http://wiki.labmovil.linti.unlp.edu.ar/index.php?title=RemoteBot:_Android_%2B_Robots 

>Para probar la aplicación de forma local con remotebot utlilizar ip 10.0.2.2 y port 8000

Flujo
======
![flujo](http://marcelocarmona.github.io/JDance/images/activities_flow.png)

Model
=====
![Model](http://marcelocarmona.github.io/JDance/images/model.png)
