import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';

export default function ButtonAppBar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar style={{backgroundColor:'#DFE0E1'}}>         
          <Typography variant="h6" component="div" sx={{ flexGrow: 1, color:'black' }}>
            e.Comerce-Gapsi
          </Typography>
          {/*<Button color="inherit">Login</Button> */} 
          <IconButton
            size="large"
            edge="start" 
            color="black"           
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
        </Toolbar>
      </AppBar>
    </Box>
  );
}