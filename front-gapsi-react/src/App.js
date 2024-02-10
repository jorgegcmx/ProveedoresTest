import React, { useContext } from 'react';
import { styled } from '@mui/material/styles';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import ButtonAppBar from './components/header';
import BodyCard from './components/BodyCard';
import PanelAdmin from './components/PanelAdmin';
import { SesionContext } from "./ContexSesion/SesionContext";

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

function App() {
  const { login } = useContext(SesionContext);
    return (
    <>
      <ButtonAppBar></ButtonAppBar>
      <Grid container spacing={2}>
        {login ? (
          <Grid item xs={12}>
            <PanelAdmin></PanelAdmin>
          </Grid>
        ) : (
          <Grid item xs={12}>
            <Item>
              <BodyCard></BodyCard>
            </Item>
          </Grid>
        )}
      </Grid>
    </>
  );
}

export default App;
