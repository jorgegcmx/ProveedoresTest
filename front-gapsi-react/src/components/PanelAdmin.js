import React, { useEffect, useState, useContext } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import Box from '@mui/material/Box';
import {
  getProveedores,
  saveProveedores,
  deleteProveedores
} from "../Services/Service";
import { SesionContext } from "../ContexSesion/SesionContext";




export default function PanelAdmin() {
  const { login, setLogin } = useContext(SesionContext);
  const columns = [
    {
      field: 'nombre',
      headerName: 'Nombre',
      width: 150,
      editable: true,
    },
    {
      field: 'razonsocial',
      headerName: 'Razón Social',
      width: 150,
      editable: true,
    },
    {
      field: 'direccion',
      headerName: 'Direccion',
      width: 200,
      editable: true,
    },
    {
      field: 'id',
      headerName: 'Accion',
      width: 200,
      editable: true,
      renderCell: (cellValues) => {
        return (
          <Button
            variant="contained"
            style={{ backgroundColor: '#E10534', color: 'white' }}
            onClick={(event) => {
              handleDelete(cellValues.id);
            }}
          >
            X
          </Button>
        );
      }
    }

  ];

  const [Proveedores, setProveedores] = useState([]);
  const [open, setOpen] = useState(false);
  const [paginationModel, setPaginationModel] = useState({
    pageSize: 25,
    page: 0,
  });
  const [NumeroRegistros, setNumeroRegistros] = useState(0);
  const [nombre, setNombre] = useState('');
  const [razonsocial, setRazonsocial] = useState('');
  const [direccion, setDireccion] = useState('');
  const [id, setId] = useState('');




  useEffect(() => {
    getProveedores(paginationModel.page,paginationModel.pageSize)
      .then((response) => {
        if (response !== '') {
          setProveedores(response.content);
          setNumeroRegistros(response.totalElements)
        }
      });

  }, [paginationModel]);


  function handleClose() {
    setOpen(false);
  }
  function handleOpen() {
    setOpen(true);
  }

  function handleSave() {
    const newProveedor = {
      "nombre": nombre,
      "razonsocial": razonsocial,
      "direccion": direccion
    }
    saveProveedores(newProveedor)
      .then((response) => {
        if (response !== '') {
          getProveedores(paginationModel.page,paginationModel.pageSize)
            .then((res) => {
              if (res !== '') {
                setProveedores(res.content);
                setNumeroRegistros(res.totalElements)
                setOpen(false);
                alert(response.mensaje);
              }
            });
        }
      }).catch((erro) => {
        console.log(erro);
      });
  }


  function handleDelete(id) {
    const deleteP = {
      "id": id
    }
      deleteProveedores(deleteP)
      .then((response) => {
        if (response !== '' && response == 'ok') {
          getProveedores(paginationModel.page,paginationModel.pageSize)
            .then((res) => {
              if (res !== '') {
                setProveedores(res.content);
                setNumeroRegistros(res.totalElements)
                alert("Proveedor Eliminado");
              }
            });
        }
      }).catch((erro) => {
        console.log(erro);
      });


  }

  function Log() {
    setLogin(false);
  }

  return (
    <div style={{ height: 400, width: '95%', padding: 30 }}>
      {/* Se implementa CDN de boostrap para fuente de letra y los iconos */}

      <Box
        sx={{
          display: 'flex',
          flexDirection: 'row-reverse',
          p: 1,
          m: 1,
          bgcolor: 'background.paper',
          borderRadius: 1,
        }}
      >
        <Button variant="contained" onClick={Log}>{login ? 'Salir' : null}</Button>
      </Box>
      <Box
        sx={{
          display: 'flex'
        }}
      >
        <p className="h1" style={{ margin: 20 }}><i className="bi bi-person-square"></i> Administración de Proveedores</p >

      </Box>
      <Box
        sx={{
          display: 'flex',
          flexDirection: 'row-reverse',
          p: 1,
          m: 1,
          bgcolor: 'background.paper',
          borderRadius: 1,
        }}
      >
        <Button variant="outlined" size="small" onClick={handleOpen}>+ Agregar Proveedor</Button>
      </Box>
      <Box
        sx={{
          display: 'flex'
        }}
      >
        <p className="h1" style={{ margin: 20 }}>Cantidad de registros {NumeroRegistros}</p >

      </Box>
      <DataGrid
        rows={Proveedores}
        columns={columns}
        paginationModel={paginationModel}
        onPaginationModelChange={setPaginationModel}
      />



      <Dialog
        open={open}
        onClose={handleClose}
      >
        <DialogTitle>Registro de Proveedores</DialogTitle>
        <DialogContent>
          <TextField
            autoFocus
            required
            margin="dense"
            id="name"
            name="email"
            label="Nombre"
            type="text"
            fullWidth
            variant="standard"
            onChange={(e) => setNombre(e.target.value.trim())}
          />
          <TextField
            autoFocus
            required
            margin="dense"
            id="name"
            name="razonsocial"
            label="Razon Social"
            type="text"
            fullWidth
            variant="standard"
            onChange={(e) => setRazonsocial(e.target.value)}
          />
          <TextField
            autoFocus
            required
            margin="dense"
            id="name"
            name="direccion"
            label="Dirección"
            type="text"
            fullWidth
            variant="standard"
            onChange={(e) => setDireccion(e.target.value)}
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancelar</Button>
          <Button type="submit" onClick={handleSave}>Registrar</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}