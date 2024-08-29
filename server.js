const express = require('express');
const app = express();
const http = require('http');
const server = http.createServer(app);
const logger = require('morgan');
const cors = require('cors');
const passport = require('passport')

/*
 *  RUTAS 
 */
const users = require('./routes/userRoutes');


const port = process.env.PORT || 3000;

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({
    extended: true
}));

app.use(cors());
app.use(passport.initialize());
app.use(passport.session());

require('./config/passport')(passport);

app.disable('x-powered-by');

app.set('port', port);

/**
 * LLAMANDO A LAS RUTAS
 */

users(app);

server.listen(3000, '192.168.56.1' || 'localhost', function() {
    console.log('Aplicacion de NodeJS ' + port + ' iniciada...')
});

app.get('/', (req, res) => {
    res.send('Ruta raiz del backend');
});

app.get('/test', (req, res) => {
  res.send('dsdds test');
});

// ERROR HANDLER
app.use((err, req, res, next)=>{
  console.log(err);
  res.status(err.status || 500).send(err.stack);
});

module.exports = {
  app: app,
  server: server
}

//200 es una respuesta exitosa 
//404 dice que la url no exite
//500 error interno del servidor
