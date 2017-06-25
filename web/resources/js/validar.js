$().ready(function () {

    function validarSesion() {
        console.log('En sistema');
        var x = localStorage.getItem('sesionActiva');
        console.log(x);

        if (x != 'usuarioActivo') {
            console.log('Inactiva');
            window.location.replace('../index.html');
        }
    }
    ;




    $('#cerrarSesion').click(function () {
        localStorage.setItem('sesionActiva', false);
    });




    $('.item').click(function () {

        var $target = $('.navbar-collapse');

        if ($target.hasClass('in')) {

            $target.removeClass('in').height(0).css('overflow', 'hidden');
        }

    });




    $('.item').click(function () {

        var $target = $('.navbar-collapse');

        if ($target.hasClass('in')) {

            $target.removeClass('in').height(0).css('overflow', 'hidden');
        }

    });



    $('#botonValidar').click(function (e) {
        e.preventDefault();

        usuario = $('#usuario').val();
        clave = $('#contrasena').val();


        if (usuario == 'admin' && clave == 'admin1') {

            sessionStorage.setItem('sesionActiva', true);
            window.location.replace('inicio.html');
        } else if (usuario == 'tecnico' && clave == 'tecnico1') {
            localStorage.setItem('sesionActiva', true);
            $('#formularioIngreso').attr('action', 'inicio.html');
            $('#formularioIngreso').submit();

        } else if (usuario == 'cliente' && clave == 'cliente1') {
            localStorage.setItem('sesionActiva', true);

            $('#formularioIngreso').attr('action', 'inicio.html');
            $('#formularioIngreso').submit();
        } else {
            console.log('Usuario no válido');
            swal("Datos incorrectos, vuelva a intentar");
        }
    });
});
