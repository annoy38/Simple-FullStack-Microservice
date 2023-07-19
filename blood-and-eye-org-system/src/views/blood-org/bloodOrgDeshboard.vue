<template>
  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item active">
              <!-- <a class="nav-link" href="#">Home</a> -->
              <router-link
                to="/blood-org-deshboard/blood-org-profile"
                class="nav-link text-dark btn"
                >Profile</router-link
              >
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Search</a> -->
              <router-link
                to="/blood-org-deshboard/blood-add-donor"
                class="nav-link text-dark btn"
                >Add Donors</router-link
              >
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Search</a> -->
              <router-link
                to="/blood-org-deshboard/blood-donor-list"
                class="nav-link text-dark btn"
                >Donor List</router-link
              >
            </li>
            <li class="nav-item active">
              <!-- <a class="nav-link" href="#">Home</a> -->
              <router-link
                to="/blood-org-deshboard/blood-four-month-completed-donor-list"
                class="nav-link text-dark btn"
                >Four month Completed Blood Donors</router-link
              >
            </li>
            <li class="nav-item active">
              <!-- <a class="nav-link" href="#">Home</a> -->
              <router-link
                to="/blood-org-deshboard/send-delivery-request"
                class="nav-link text-dark btn"
                >Send Delivery Request</router-link
              >
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Search</a> -->
              <router-link
                to="/blood-org-deshboard/blood-delivery-request-list"
                class="nav-link text-dark btn"
                >Delivery Request List</router-link
              >
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Blood Bank Registration</a> -->
              <router-link to="/blood-org-deshboard/blood-request-list" class="nav-link text-dark btn"
                >Blood Requests</router-link
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
export default {
  name: "bloodOrgDeshboard",
  methods: {
    logout() {
      localStorage.removeItem("token");
      localStorage.clear();
      this.$router.push("/blood-org-login");
    },
  },
};
</script>

<style></style>
