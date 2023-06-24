$(document).on('change', '#txtTipoDocumento', function (ev) {
    ev.preventDefault();
    var codigo = $(this).val();
    alert("Codigo: " + codigo);
});