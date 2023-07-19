<template>
  <section class="vh-100">
    <div class="container py-5 h-100">
      <div class="row d-flex align-items-center justify-content-center h-100">
        <div v-if="showAlert" class="alert alert-dismissible alert-success">
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert"
          ></button>
          <strong>{{ alertMessage }}</strong>
        </div>
        <div class="col-md-8 col-lg-7 col-xl-6">
          <img
            src="../../assets/system-administrator-4487123-3726273.png"
            class="img-fluid"
            alt="Phone image"
          />
        </div>
        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
          <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-dark">
            Admin Login
          </p>
          <form @submit="loginAdmin">
            <!-- Email input -->
            <div class="form-outline mb-4">
              <input
                type="email"
                id="adminEmail"
                class="form-control form-control-lg"
                placeholder="Enter Email"
                v-model="adminEmail"
              />
              <!-- <label class="form-label" for="form1Example13">Email address</label> -->
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
              <input
                type="password"
                id="adminPassword"
                class="form-control form-control-lg"
                placeholder="Enter Password"
                v-model="adminPassword"
              />
              <!-- <label class="form-label" for="form1Example23">Password</label> -->
            </div>

            <!-- Submit button -->
            <button type="submit" class="btn btn-success btn-lg btn-block">
              Login
            </button>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "adminLogin",
  data() {
    return {
      adminEmail: "",
      adminPassword: "",
      showAlert: "",
      alertMessage: "",
    };
  },
  methods: {
    loginAdmin(event) {
      event.preventDefault();
      if (
        this.adminEmail == "shahariarhayder45@gmail.com" &&
        this.adminPassword == "admin"
      ) {
        this.showAlert = true;
        this.alertMessage = "Login successful";
        setTimeout(() => {
          this.$router.push("/admin-deshboard"); // Redirect to the dashboard page
        }, 3000);
      }
    },
  },
};
</script>

<style></style>
