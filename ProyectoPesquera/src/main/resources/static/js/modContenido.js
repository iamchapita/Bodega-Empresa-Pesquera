function hideShowContent() {
  if (document.getElementById("Limpio").checked == true) {

    var SelectLimpio = document.getElementById("SelectLimpio");
    var SelectEntero = document.getElementById("SelectEntero");

    SelectLimpio.required = true;
    SelectLimpio.style.display = "block";
    SelectEntero.required = false;
    SelectEntero.style.display = "none";

    document.getElementById("inputEmpleadoLimpio").style.display = "block";
    document.getElementById("inputEmpleadoLimpio").required = true;
    document.getElementById("inputEmpleadoLimpio").setAttribute("name", "numEmpleados");
    document.getElementById("inputEmpleadoEntero").style.display = "none";
    document.getElementById("inputEmpleadoEntero").required = false;
    document.getElementById("inputEmpleadoEntero").value = "";
    document.getElementById("inputEmpleadoEntero").removeAttribute("name");

    $("#selectEntero option:selected").prop("selected", false);
    $("#selectEntero_val").val("");

  } else {
    var SelectLimpio = document.getElementById("SelectLimpio");
    var SelectEntero = document.getElementById("SelectEntero");

    SelectEntero.style.display = "block";
    SelectEntero.required = true;
    SelectLimpio.style.display = "none";
    SelectLimpio.required = false;

    $("#selectLimpio option:selected").prop("selected", false);
    $("#selectLimpio_val").val("");

    document.getElementById("inputEmpleadoLimpio").style.display = "none";
    document.getElementById("inputEmpleadoLimpio").required = false;
    document.getElementById("inputEmpleadoLimpio").value = "";
    document.getElementById("inputEmpleadoEntero").style.display = "block";
    document.getElementById("inputEmpleadoEntero").required = true;
    document.getElementById("inputEmpleadoEntero").setAttribute("name", "numEmpleados");
    document.getElementById("inputEmpleadoLimpio").removeAttribute("name");
    
  }
}
