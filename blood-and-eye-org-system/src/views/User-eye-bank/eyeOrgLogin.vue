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
            src="../../assets/female-ophthalmologist-checking-patients-eyesight_701961-577.jpg"
            class="img-fluid"
            alt="Phone image"
          />
        </div>
        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
          <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-dark">
            Login
          </p>
          <form @submit="loginEyeOrg($event)">
            <!-- Email input -->
            <div class="form-outline mb-4">
              <input
                type="email"
                id="orgEmail"
                class="form-control form-control-lg"
                placeholder="Enter Email"
                v-model="LoginRequestClass.orgEmail"
              />
              <!-- <label class="form-label" for="form1Example13">Email address</label> -->
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
              <input
                type="password"
                id="orgPassword"
                class="form-control form-control-lg"
                placeholder="Enter Password"
                v-model="LoginRequestClass.orgPassword"
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
import backendEyeRestApi from '@/service/backendEyeRestApi';
export default {
  name: "eyeOrgLogin",
  data() {
    return {
      LoginRequestClass: {
        orgEmail: "",
        orgPassword: "",
      },
      token: "",
      showAlert: "",
      alertMessage: "",
    };
  },
  methods:{
    loginEyeOrg(event){
      event.preventDefault();
      backendEyeRestApi.loginEyeOrganization(this.LoginRequestClass)
      .then((response)=>{
        const token = response.data;
        localStorage.setItem("token", token);

        if(response.data){
          this.showAlert = true;
          this.alertMessage = "Login Successful";
          setTimeout(()=>{
            this.$router.push("/eye-org-deshboard/eye-org-profile");
          }, 3000)
        }
      });
    }
  }
};
</script>

<style></style>
