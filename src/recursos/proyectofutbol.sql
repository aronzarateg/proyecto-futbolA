-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 01-07-2014 a las 15:07:31
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `proyectofutbol`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `campeonato`
-- 

CREATE TABLE `campeonato` (
  `idCampeonato` int(10) unsigned NOT NULL auto_increment,
  `Nombre_campeonato` varchar(45) default NULL,
  `Fecha_inicio` date default NULL,
  `Fecha_fin` date default NULL,
  PRIMARY KEY  (`idCampeonato`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

-- 
-- Volcar la base de datos para la tabla `campeonato`
-- 

INSERT INTO `campeonato` VALUES (4, 'desentralizado', '2014-06-12', '2014-06-05');
INSERT INTO `campeonato` VALUES (3, 'Union', '2014-06-08', '2014-06-15');
INSERT INTO `campeonato` VALUES (5, 'champions', '2014-06-29', '2015-06-18');
INSERT INTO `campeonato` VALUES (8, 'libertadores', '2014-07-02', '2015-06-24');
INSERT INTO `campeonato` VALUES (9, 'copA01', '2014-06-14', '2014-06-22');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `equipo`
-- 

CREATE TABLE `equipo` (
  `idEquipo` int(10) unsigned NOT NULL auto_increment,
  `idCampeonato` int(10) unsigned NOT NULL,
  `Nombre_equipo` varchar(30) default NULL,
  `Nombre_Estadio` varchar(45) default NULL,
  `An_Fundacion` date default NULL,
  `Ciudad` varchar(45) default NULL,
  PRIMARY KEY  (`idEquipo`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

-- 
-- Volcar la base de datos para la tabla `equipo`
-- 

INSERT INTO `equipo` VALUES (1, 4, 'U', 'lima_norte', '2014-06-03', 'lima');
INSERT INTO `equipo` VALUES (2, 4, 'alianza', 'matute', '2014-06-05', 'lima');
INSERT INTO `equipo` VALUES (3, 4, 'intigas', 'ayacuho', '2014-06-20', 'ayacucho');
INSERT INTO `equipo` VALUES (4, 4, 'cesar vallejo', 'cantera - lima', '2014-06-16', 'trujillo');
INSERT INTO `equipo` VALUES (7, 4, 'Sport Huancayo', 'Huancayo', '2014-06-06', 'Huancayo');
INSERT INTO `equipo` VALUES (8, 4, 'Sporting Cristal', 'Alberto Gallardo', '1955-12-13', 'Lima-Peru');
INSERT INTO `equipo` VALUES (9, 4, 'Juan Aurich S.A', 'Elias Aguirre', '1922-09-03', 'Chiclayoperu');
INSERT INTO `equipo` VALUES (10, 4, 'Cienciano del Cusco', 'Inca Garcilazo de la vega', '1901-07-08', 'CuzcoPeru');
INSERT INTO `equipo` VALUES (11, 4, 'k', 'k', '2014-06-06', 'k');
INSERT INTO `equipo` VALUES (12, 3, 'k', 'k', '2014-06-07', 'k');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `jugador`
-- 

CREATE TABLE `jugador` (
  `idJugador` int(10) unsigned NOT NULL auto_increment,
  `idEquipo` int(10) unsigned NOT NULL,
  `Nombre` varchar(20) default NULL,
  `ap_Jugador` varchar(30) default NULL,
  `am_Jugador` varchar(30) default NULL,
  `Posicion` varchar(30) default NULL,
  `Fecha_Nac` date default NULL,
  PRIMARY KEY  (`idJugador`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `jugador`
-- 

INSERT INTO `jugador` VALUES (1, 2, 'juan', 'machado', 'yucra', 'portero', '1996-06-11');
INSERT INTO `jugador` VALUES (2, 3, 'pedro', 'solorzano', 'carillo', 'delantero', '2014-06-05');
INSERT INTO `jugador` VALUES (3, 2, 'Aron', 'zarate', 'Gonzales', 'defensa', '2014-06-06');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `jugador_has_campeonato`
-- 

CREATE TABLE `jugador_has_campeonato` (
  `idJugador` int(10) unsigned NOT NULL,
  `idCampeonato` int(10) unsigned NOT NULL,
  `Targeta_roja` int(10) unsigned default NULL,
  `Targeta_amarilla` int(10) unsigned default NULL,
  PRIMARY KEY  (`idJugador`,`idCampeonato`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `jugador_has_campeonato`
-- 

INSERT INTO `jugador_has_campeonato` VALUES (0, 0, 1, 2);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `jugador_has_partido`
-- 

CREATE TABLE `jugador_has_partido` (
  `idJugador` int(10) unsigned NOT NULL,
  `idPartido` int(10) unsigned NOT NULL,
  `Min_gol` varchar(10) default NULL,
  `Descripcion` varchar(40) default NULL,
  `Cantidad_gol` int(10) unsigned default NULL,
  PRIMARY KEY  (`idJugador`,`idPartido`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `jugador_has_partido`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `partido`
-- 

CREATE TABLE `partido` (
  `idPartido` int(10) unsigned NOT NULL auto_increment,
  `idEquipo` int(10) unsigned NOT NULL,
  `idCampeonato` int(10) unsigned NOT NULL,
  `Gol_Casa` int(10) unsigned default NULL,
  `Gol_Visita` int(10) unsigned default NULL,
  `Fecha_partido` date default NULL,
  PRIMARY KEY  (`idPartido`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `partido`
-- 

INSERT INTO `partido` VALUES (1, 2, 1, 2, 1, '2014-06-11');
INSERT INTO `partido` VALUES (2, 1, 1, 4, 4, '2014-06-05');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `presidente`
-- 

CREATE TABLE `presidente` (
  `idPresidente` int(10) unsigned NOT NULL auto_increment,
  `idCampeonato` int(10) unsigned NOT NULL,
  `idEquipo` int(10) unsigned NOT NULL,
  `Nombre_pres` varchar(30) default NULL,
  `Ap_presidente` varchar(30) default NULL,
  `Am_presidente` varchar(30) default NULL,
  `Dni` varchar(7) default NULL,
  `Sexo` char(1) default NULL,
  `Fec_Nac` date default NULL,
  `Fecha_presidente` date default NULL,
  `Telefono` varchar(30) default NULL,
  PRIMARY KEY  (`idPresidente`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

-- 
-- Volcar la base de datos para la tabla `presidente`
-- 

INSERT INTO `presidente` VALUES (1, 3, 3, 'anthony', 'baltazar', 'chamorro', '3245322', 'M', '2014-06-18', '2014-06-26', '123');
INSERT INTO `presidente` VALUES (2, 4, 1, 'juancito', 'peralta', 'aguirre', '23423', 'M', '2014-06-04', '2014-06-05', '966472896');
INSERT INTO `presidente` VALUES (6, 5, 4, 'Federico', 'Cuneo', '', '123456', 'M', '2014-06-04', '1989-06-10', '234214');
INSERT INTO `presidente` VALUES (4, 4, 2, 'Eduardo', 'lima', 'guevara', '6789009', 'M', '2014-06-06', '2014-06-07', '123123');
INSERT INTO `presidente` VALUES (5, 4, 7, 'juan', 's', 's', '23', 'M', '2014-06-06', '2014-06-14', '3412312');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuario`
-- 

CREATE TABLE `usuario` (
  `idUsuario` int(10) unsigned NOT NULL auto_increment,
  `usuario` varchar(25) default NULL,
  `clave` varchar(35) default NULL,
  PRIMARY KEY  (`idUsuario`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

-- 
-- Volcar la base de datos para la tabla `usuario`
-- 

INSERT INTO `usuario` VALUES (1, 'aron', 'aron');
INSERT INTO `usuario` VALUES (8, 'jeferson340', 'cueva');
INSERT INTO `usuario` VALUES (9, 'aron230', '1456');
INSERT INTO `usuario` VALUES (24, 'georgec', '1234');
INSERT INTO `usuario` VALUES (30, 'eduardo', 'aduardo12');
INSERT INTO `usuario` VALUES (26, 'pocho', '345');
INSERT INTO `usuario` VALUES (32, 'pochito01', 'juanCesar');
INSERT INTO `usuario` VALUES (29, 'admin', '123');
