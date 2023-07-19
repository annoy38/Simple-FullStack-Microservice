<template>
  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item active">
              <!-- <a class="nav-link" href="#">Home</a> -->
              <router-link to="/blood-bank-home" class="nav-link text-dark"
                >Home</router-link
              >
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Search</a> -->
              <router-link to="/search-blood" class="nav-link text-dark"
                >Search</router-link
              >
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Blood Bank Registration</a> -->
              <router-link to="/blood-org-registration" class="nav-link text-dark"
                >Blood Bank Registration</router-link
              >
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Blood Bank Login</a> -->
              <router-link to="/blood-org-login" class="nav-link text-dark"
                >Blood Bank Login</router-link
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <HelloWorld />
  </div>
  <router-view />
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "HomeView",
  components: {
    HelloWorld,
  },
};
</script>
