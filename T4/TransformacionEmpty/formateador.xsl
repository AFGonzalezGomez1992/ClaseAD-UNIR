<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet  version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Peliculas cartelera</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"/>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
                <link
                        rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
                />
            </head>
            <body>
                <main class="container">
                    <h1>Transformación de peliculas</h1>
                    <div>
                        <h2>Transformaciones via XSL - FOREACH</h2>
                        
                        <!--<xsl:for-each select="xquery version='3.0'
                            for $pelicula in doc('peliculas.xml')/peliculas/pelicula
                            let $i = $pelicula/@titulo
                            where $pelicula/@puntuacion > 8
                            order by $pelicula/@puntuacion
                            return $pelicula/personajes/"></xsl:for-each>-->
                        <!--<xsl:for-each select="peliculas/pelicula[@puntuacion>9]">
                            <li>
                                <xsl:value-of select="@titulo"/>
                            </li>
                        </xsl:for-each>-->
                        <!--<div class="row">
                            <div class="col">
                                <xsl:for-each select="peliculas/pelicula">
                                    <div class="card" style="width: 18rem;">
                                        <img  class="card-img-top" alt="...">
                                            <xsl:attribute name="src">
                                                <xsl:value-of select="@poster"
                                            </xsl:attribute>
                                        </img>
                                        <div class="card-body">
                                            <h5 class="card-title">
                                                <xsl:value-of select="@titulo"/>
                                            </h5>
                                            <p class="card-text">
                                                <xsl:value-of select="sinopsis"
                                            </p>
                                            <a class="btn btn-primary">
                                                <xsl:attribute name="href">
                                                    <xsl:value-of select="@poster"/>
                                                </xsl:attribute>
                                                Ir a la web
                                            </a>
                                        </div>
                                    </div>
                                </xsl:for-each>
                            </div>
                        </div>-->
                        <!--<ul class="list-group">
                            <xsl:for-each select="peliculas/pelicula">
                                <li class="list-group-item">
                                <xsl:attribute name="style">
                                    <xsl:choose>
                                        <xsl:when test="@genero='Acción'">
                                            background-color:#3cb371;
                                            font-size:15px
                                        </xsl:when>
                                        <xsl:when test="@genero='Crimen'">
                                            background-color:#6a5acd;
                                            font-size:20px
                                        </xsl:when>
                                        <xsl:when test="@genero='Drama'">
                                            background-color:#3cb371;
                                            font-size:25px
                                        </xsl:when>
                                        <xsl:when test="@genero='Western'">
                                            background-color:#ffa500;
                                            font-size:30px
                                        </xsl:when>
                                        <xsl:otherwise>
                                            background-color:#6a5acd;
                                            font-size:10px
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </xsl:attribute>
                                    <xsl:value-of select="@titulo"/>
                                </li>
                            </xsl:for-each>
                        </ul>-->

                    </div>
                </main>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>