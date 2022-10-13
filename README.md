# cupon

    Esta aplicacion implementa un nuevo beneficio para los usuarios que más usan la
    plataforma con un cupón de cierto monto gratis que les permitirá comprar tantos ítems
    marcados como favoritos que no excedan el monto total. Para esto se está analizando
    construir una API que dado una lista de item_id y el monto total pueda darle la lista de ítems
    que maximice el total gastado.
    Aclaraciones:
    - Sólo se puede comprar una unidad por item_id.
    - No hay preferencia en la cantidad total de ítems siempre y cuando gasten el máximo
    posible.
    - El precio puede contener hasta 2 decimales. 
    


<img width="524" alt="image" src="https://user-images.githubusercontent.com/89594527/195502576-4b61f0b2-8513-4b48-a855-e9c9c3cc5fad.png">


#instalacion

  - Debes tener instalado java 11
  - tener instalado Gradle 7
  - se conecta a una BD postgres en google cloud. 
    --ip: 34.125.76.111 (postgres:332817)
  - ejecuta en la terminal "gradle run"
  - en el navegador entra a "http://localhost:8080/swagger-ui/index.html"
  
#como se usa

  -Puedes usar el link "http://localhost:8080/swagger-ui/index.html" (usar la aplicacion local) o puedes ingresar al siguiente 
     link "http://34.125.76.111:8080/swagger-ui/index.html"

  - ingresa a la siguiente url "https://api.mercadolibre.com/sites/MCO/categories", selecciona el id que desees.
  <img width="312" alt="image" src="https://user-images.githubusercontent.com/89594527/195500272-623554e3-876c-459d-9912-bd197d08d98c.png">

  - ve a "https://api.mercadolibre.com//sites/MCO/search?category=ID_CATEGORIA" (ID_CATEGORIA es el id que seleccionaste en el link anterior).
  - abre la lista de result.
  <img width="308" alt="image" src="https://user-images.githubusercontent.com/89594527/195500677-bef062ea-13ab-4479-b911-51c006f33582.png">
  
  - slecciona la cantidad de items que desees y copia el valor del atributo id de cada item
  <img width="579" alt="image" src="https://user-images.githubusercontent.com/89594527/195500952-9527cb71-6723-417b-846d-fbf431e7974d.png">

  - en el swwager-ui entra "comando-controlador-item", escribe un valor mayor a 0 en el campo CUPON y pega los id que seleccionaste en la lista.
  <img width="960" alt="image" src="https://user-images.githubusercontent.com/89594527/195501326-bf420f30-d2d3-47f0-9dd7-994b829dc4ca.png">
  
  - te respondera con la lista de items que puedes comprar sin exceder el limite del cupon, tambien el precio total de los items comprados y el valor del cupon.
      (La lista esta ordenada del menor precio al mayor).
      
      <img width="526" alt="image" src="https://user-images.githubusercontent.com/89594527/195502928-abcb6fb5-676d-4ec5-95b2-21e3f4260131.png">

      
  
  - entra a "consulta-controlador-item", dale click a execute. Te respondera con una lista de los 5 items mas vendidos segun las listas de items favoritos. 
    (La lista esta organizada del mas vendido al menos vendido)
    
    <img width="542" alt="image" src="https://user-images.githubusercontent.com/89594527/195504259-dbf258f3-4d95-446e-a48d-eaac9a164a93.png">


  
