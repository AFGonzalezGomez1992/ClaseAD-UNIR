async function getAllUser() {
    let respuesta= await fetch("http://localhost:8080/usuarios/getAll")
    let respuestaJSON = await respuesta.json();
    console.log(respuestaJSON);
}

getAllUser();