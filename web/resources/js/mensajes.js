$('#table').bootstrapTable({
    formatNoMatches: function () {
        return "<div><span class='fa fa-envelope-o' style='color:#ccc;font-size:170px'></span><h3><strong>No hay mensajes</strong></h3><h4>No hay mensajes en esta conversación, seleccione otro usuario o<h3> Inicie la conversación</h3> <span class='fa fa-arrow-down fa-3x'></span></h4></div>";
    }
});

$('#eliminar').click(function () {

    var seleccionados = JSON.stringify($('table').bootstrapTable('getSelections'));

    if (seleccionados != '[]') {
        var ids = $.map($('#table').bootstrapTable('getSelections'), function (row) {
            return row.mensaje;
        });
        $('#table').bootstrapTable('remove', {
            field: 'mensaje',
            values: ids
        });
    }
});

// enviar mensaje
var cantidadFilas = $('#table').bootstrapTable('getData').length;

