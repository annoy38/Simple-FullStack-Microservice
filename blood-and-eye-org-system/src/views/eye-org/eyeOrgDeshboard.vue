<template>
    <div class="container">
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mx-auto">
              <li class="nav-item active">
                <!-- <a class="nav-link" href="#">Home</a> -->
                <router-link
                  to="/eye-org-deshboard/eye-org-profile"
                  class="nav-link text-dark btn"
                  >Profile</router-link
                >
              </li>
              <li class="nav-item">
                <!-- <a class="nav-link" href="#">Search</a> -->
                <router-link
                  to="/eye-org-deshboard/eye-add-donor"
                  class="nav-link text-dark btn"
                  >Add Eye Donors</router-link
                >
              </li>
              <li class="nav-item">
                <!-- <a class="nav-link" href="#">Search</a> -->
                <router-link
                  to="/eye-org-deshboard/eye-donor-list"
                  class="nav-link text-dark btn"
                  >Donor List</router-link
                >
              </li>
              <li class="nav-item active">
                <!-- <a class="nav-link" href="#">Home</a> -->
                <router-link
                  to="/eye-org-deshboard/eye-delivery-request"
                  class="nav-link text-dark btn"
                  >Send Delivery Request</router-link
                >
              </li>
              <li class="nav-item">
                <!-- <a class="nav-link" href="#">Search</a> -->
                <router-link
                  to="/eye-org-deshboard/eye-delivery-request-list"
                  class="nav-link text-dark btn"
                  >Delivery Request List</router-link
                >
              </li>
              <li class="nav-item">
                <!-- <a class="nav-link" href="#">Blood Bank Registration</a> -->
                <router-link to="/eye-org-deshboard/eye-request-list" class="nav-link text-dark btn"
                  >Eye Requests</router-link
                >
              </li>
              <li class="nav-item">
                <!-- <a class="nav-link" href="#">Blood Bank Registration</a> -->
                <button type="button" @click="logout()">Logout</button>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <router-view></router-view>
    </div>
  </template>

<script>

export default{
    name: "eyeOrgDeshboard",
    methods: {
    logout() {
      localStorage.removeItem("token");
      localStorage.clear();
      this.$router.push("/eye-bank/eye-org-login");
    },
  },
}
</script>


<style>


</style>