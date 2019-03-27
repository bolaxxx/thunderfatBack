<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<spring:url value="/" var="urlRoot"/>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <li class="nav-item text-nowrap">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">ThunderFat Nutrition App</a>
</li>
<!--       <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search"> -->
<!--       <ul class="navbar-nav px-3"> -->
<!--         <li class="nav-item text-nowrap"> -->
<!--           <a class="nav-link" href="#">Sign out</a> -->
<!--         </li> -->
<!--       </ul> -->
       <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Pacientes</a>
        </li>
      </ul>
       <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Citas</a>
        </li>
      </ul>
       <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Platos Predeterminados</a>
        </li>
      </ul>
       <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Filtros Alimentarios</a>
        </li>
      </ul>
       <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Planes de Dieta</a>
        </li>
      </ul>
       <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="${urlRoot}admin/logout">Sign out</a>
        </li>
      </ul>
    </nav>