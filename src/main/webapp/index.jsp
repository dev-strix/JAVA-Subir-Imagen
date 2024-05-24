<html>

    <head>

        <title>Upload Images</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.0/darkly/bootstrap.min.css" integrity="sha384-Bo21yfmmZuXwcN/9vKrA5jPUMhr7znVBBeLxT9MA4r2BchhusfJ6+n8TLGUcRAtL" crossorigin="anonymous">
    </head>

    <body>
        <div class="container p-5">
            <div class="row flex-column justify-content-center">
                <h1 class="bg-danger col-sm-8 m-auto text-center p-2">Subir Imagen</h1>
                <form class="col-sm-8 m-auto p-2" action="CustomerServlet" method="post" enctype="multipart/form-data">				
                    <!--div class="form-group">
                            <input class="form-control" name="name" type="text" placeholder="Ingrese un nombre" />
                    </div-->			
                    <div class="form-group">
                        <input class="form-control" name="file" type="file" accept=".png, .jpg, .jpeg"/> placeholder="ppp" />
                    </div>				
                    <div class="form-group text-center">
                        <button class="btn btn-success" name="action" value="add">SubirIMG</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>