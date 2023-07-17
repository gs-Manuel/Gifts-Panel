# SOLUCIÓN 2022/2023
## Cosas a tener en cuenta sobre esta solución:
- Los usuarios, según el enunciado, ya existen y hay que darles validez,  esto implicaría importar estos datos de los usuarios de una base de datos, así que, para reducir el tamaño del problema(ya que no me proporcionan esos datos), crearé yo la base de datos que almacene a los usuarios, que se harán socios al comprar en los almacenes.
- Los usuarios pueden hacer login y register, de manera que permite la admisión de nuevos usuarios así como da validez a los que ya lo eran.
### 10/07
- Durante la implementación, me doy cuenta de que va a ser necesario hacer 2 aplicaciones, una para el usuario que compra y otra para el vendedor, esta última le debe permitir validarse como usuario vendedor y le debe permitir añadir imágenes a los productos que añada
### 11/07
- Observando los requerimientos de la aplicación y con la intención de emplear herramientas de uso laboral, me decido a cambiar el IDE para empezar a usar Intelij, software que es más usado en el mundo laboral, integra Maven, framework que planeo utilizar y tiene una herramienta nativa de desarrollo de interfaces GUI Designer, a diferencia de eclipse que necesita la instalación de un plug-in: Window Builder
- Me planteo utilizar el plug-in JFormDesigner en vez de GUI Designer, en una investigación rápida, parece software más actualizado y tiene una documentación muy legible y fácil de entender.
### 12/07
- Completo la migración del proyecto a intelij y descarto la opción de utilizar JFormDesigner al ver que es una herramienta de pago
## 15/07 
- Descubro JavaFX -> Framework más nuevo que Java Swing, es OpenSource.
## 17/07
- Me decido a Utilizar JavaFX para la interfaz de usuario
- Utilizaré MVC(Modelo - Vista - Controlador)
- Utilizaré Maven para gestionar las dependencias con mayor facilidad