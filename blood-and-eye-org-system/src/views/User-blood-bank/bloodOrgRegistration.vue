<template>
  <section class="vh-100" style="background-color: #eee">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-lg-12 col-xl-11">
          <div class="card text-black" style="border-radius: 25px">
            <div class="card-body p-md-5">
              <div class="row justify-content-center">
                <div
                  v-if="showAlert"
                  class="alert alert-dismissible alert-success"
                >
                  <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="alert"
                  ></button>
                  <strong>Registration Successful! {{ alertMessage }}</strong>
                </div>
                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                  <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                    Registration
                  </p>

                  <form
                    class="mx-1 mx-md-4"
                    @submit="orgRegistration"
                    method="post"
                  >
                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="text"
                          id="orgName"
                          class="form-control"
                          placeholder="Enter Organization Name"
                          v-model="accountClass.orgName"
                        />
                        <!-- <label class="form-label" for="form3Example1c">Your Name</label> -->
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="text"
                          id="orgNumber"
                          class="form-control"
                          placeholder="Enter Number"
                          v-model="accountClass.orgNumber"
                        />
                        <!-- <label class="form-label" for="form3Example3c">Your Email</label> -->
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="email"
                          id="orgEmail"
                          class="form-control"
                          placeholder="Enter Email"
                          v-model="accountClass.orgEmail"
                        />
                        <!-- <label class="form-label" for="form3Example3c">Your Email</label> -->
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="text"
                          id="orgDivision"
                          class="form-control"
                          placeholder="Enter Division"
                          v-model="accountClass.orgDivision"
                        />
                        <!-- <label class="form-label" for="form3Example3c">Your Email</label> -->
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="text"
                          id="orgDistric"
                          class="form-control"
                          placeholder="Enter Distric"
                          v-model="accountClass.orgDistric"
                        />
                        <!-- <label class="form-label" for="form3Example3c">Your Email</label> -->
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="text"
                          id="orgUpazila"
                          class="form-control"
                          placeholder="Enter Upazila"
                          v-model="accountClass.orgUpazila"
                        />
                        <!-- <label class="form-label" for="form3Example3c">Your Email</label> -->
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="text"
                          id="orgType"
                          class="form-control"
                          placeholder="Enter Organization Type"
                          v-model="accountClass.orgType"
                        />
                        <!-- <label class="form-label" for="form3Example3c">Your Email</label> -->
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="password"
                          id="orgPassword"
                          class="form-control"
                          placeholder="Enter Password"
                          v-model="accountClass.orgPassword"
                        />
                        <!-- <label class="form-label" for="form3Example4c">Password</label> -->
                      </div>
                    </div>

                    <div
                      class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                    >
                      <button type="submit" class="btn btn-success btn-lg">
                        Register
                      </button>
                    </div>
                  </form>
                </div>
                <div
                  class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2"
                >
                  <img
                    src="../../assets/istockphoto-1334961242-612x612.jpg"
                    class="img-fluid"
                    alt="Sample image"
                  />
                  <!-- src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp" -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "bloodOrgRegistration",
  data() {
    return {
      accountClass: {
        orgName: "",
        orgNumber: "",
        orgEmail: "",
        orgDivision: "",
        orgDistric: "",
        orgUpazila: "",
        orgType: "",
        orgPassword: "",
      },
      showAlert: false,
      alertMessage: "",
    };
  },
  methods: {
    orgRegistration(event) {
      event.preventDefault();
      console.log(this.accountClass);

      backendRestApi
        .registrationBloodOrg(this.accountClass)
        .then((response) => {
          this.showAlert = true;
          this.alertMessage = response.data;
          console.log(this.alertMessage);
          setTimeout(() => {
            this.showAlert = false;
            this.alertMessage = "";
            this.$router.push("/blood-org-login");
          }, 5000);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style></style>
