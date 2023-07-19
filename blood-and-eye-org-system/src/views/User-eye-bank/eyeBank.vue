<template>
  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item active">
              <router-link to="/eye-bank/eye-home" class="nav-link text-dark"
                >Home</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/eye-bank/eye-search" class="nav-link text-dark"
                >Search</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/eye-bank/eye-org-registration" class="nav-link text-dark"
                >Eye Bank Registration</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/eye-bank/eye-org-login" class="nav-link text-dark"
                >Eye Bank Login</router-link
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "eyeBank",
};
</script>

<style></style>
