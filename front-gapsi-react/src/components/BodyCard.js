import React, { useEffect, useState, useContext } from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import logo from '../imges/logo.png'
import {
    getCandidato
} from "../Services/Service";
import { SesionContext } from "../ContexSesion/SesionContext";


export default function BodyCard() {
    const { setLogin } = useContext(SesionContext);

    const InitialState = {
        candidato: "",
        version: ""
    }

    const [Candidato, setCandidato] = useState(InitialState);

    useEffect(() => {
        getCandidato()
            .then((response) => {
                if (response !== '') {
                       setCandidato(response);
                }
            });

    }, []);

    function Log() {
        setLogin(true);
    }

    return (
        <Card style={{ height: 500, paddingTop: 100 }} >
            <img src={logo} />
            <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                    Bienvenido {Candidato.candidato}
                </Typography>
                <Button variant="contained" onClick={Log}>Continuar</Button>
            </CardContent>
            <div style={{ alignContent: 'flex-end' }}>
                <Typography variant="body2" component="div">
                    {Candidato.version}
                </Typography>
            </div>
        </Card>
    );
}