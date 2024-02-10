import axios from "axios";

export function getCandidato() {
  const url = "http://localhost:8080/candidato";
  const promise = axios.get(url);
  const dataPromise = promise.then((response) => response.data);
  return dataPromise;
}

export function getProveedores(page, size) { 
    const url = `http://localhost:8080/lista_proveedores_paginados?page=${page}&size=${size}`;
    const promise = axios.get(url);
    const dataPromise = promise.then((response) => response.data);
    return dataPromise;
  }


  export function saveProveedores(data) {
    const url = "http://localhost:8080/guarda_proveedores";
    const promise = axios.post(url,data);
    const dataPromise = promise.then((response) => response.data);
    return dataPromise;
  }


  export function deleteProveedores(data) {
    const url = "http://localhost:8080/elimina_proveedores";
    const promise = axios.post(url,data);
    const dataPromise = promise.then((response) => response.data);
    return dataPromise;
  }