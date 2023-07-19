<template>
  <div class="container">
    <h1 class="mt-4 text-dark">Send Eye Request to {{ this.eyeOrgName }}</h1>

    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      <strong>{{ alertMessage }}</strong>
    </div>
    <div class="row mb-4">
      <div class="col">
        <img src="../../assets/eye_request.avif" class="center-block" alt="" />
      </div>
      <div class="col mt-5" v-if="this.EyeRequestClass.eyeOrganizationEmail">
        <form @submit="sendEyeReq($event)">
          <div class="form-group row mt-5">
            <label
              for="eyeOrganizationEmail"
              class="col-sm-5 col-form-label text-dark"
              >Enter Eye Organization Email:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="eyeOrganizationEmail"
                v-model="EyeRequestClass.eyeOrganizationEmail"
                readonly
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="patientName" class="col-sm-5 col-form-label text-dark"
              >Patient Name:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientName"
                v-model="EyeRequestClass.patientName"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="patientNumber" class="col-sm-5 col-form-label text-dark"
              >Patient Number :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientNumber"
                v-model="EyeRequestClass.patientNumber"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label
              for="patientAddress"
              class="col-sm-5 col-form-label text-dark"
              >Patient Address :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientAddress"
                v-model="EyeRequestClass.patientAddress"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="patientGender" class="col-sm-5 col-form-label text-dark"
              >Patient Gender :</label
            >
            <div class="col-sm-6">
              <select
                class="form-control"
                v-model="EyeRequestClass.patientGender"
                id="patientGender"
              >
                <option selected>Select Gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
              </select>
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="patientAge" class="col-sm-5 col-form-label text-dark"
              >Patient Age :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="patientAge"
                v-model="EyeRequestClass.patientAge"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label
              for="patientBloodType"
              class="col-sm-5 col-form-label text-dark"
              >Patient Blood Type :</label
            >
            <div class="col-sm-6">
              <select
                class="form-control"
                v-model="EyeRequestClass.patientBloodType"
                id="patientBloodType"
              >
                <option selected>Select Blood Type</option>
                <option value="A+">A+</option>
                <option value="A-">A-</option>
                <option value="B+">B+</option>
                <option value="B-">B-</option>
                <option value="AB+">AB+</option>
                <option value="AB-">AB-</option>
                <option value="O+">O+</option>
                <option value="O-">O-</option>
              </select>
            </div>
          </div>

          <button type="submit" class="btn btn-success mt-5">
            Send Eye Request
          </button>
        </form>
      </div>
    </div>
  </div>
  <footer class="footer bg-success py-4">
    <div class="container text-center">
      <span class="text-muted">This is the footer content.</span>
    </div>
  </footer>
</template>

<script>
import backendEyeRestApi from "@/service/backendEyeRestApi";
export default {
  name: "sendEyeRequest",
  data() {
    return {
      EyeRequestClass: {
        eyeOrganizationEmail: "",
        patientName: "",
        patientNumber: "",
        patientAddress: "",
        patientGender: "",
        patientAge: "",
        patientBloodType: "",
      },
      eyeOrgName: "",
      showAlert: false,
      alertMessage: "",
    };
  },
  created() {
    this.eyeOrgName = this.$route.params.orgName;
    this.EyeRequestClass.eyeOrganizationEmail = this.$route.params.orgEmail;
  },
  methods: {
    async sendEyeReq(event) {
      event.preventDefault();
      backendEyeRestApi
        .sendEyeRequest(this.EyeRequestClass)
        .then((response) => {
          if (response.data) {
            this.showAlert = true;
            this.alertMessage = "Eye Request Sended";
            setTimeout(() => {
              this.showAlert = false;
              this.alertMessage = "";
              this.EyeRequestClass = {
                eyeOrganizationEmail: "",
                patientName: "",
                patientNumber: "",
                patientAddress: "",
                patientGender: "",
                patientAge: "",
                patientBloodType: "",
              };
            }, 3000);
          }
        })
        .catch((error) => {
          this.showAlert = true;
          this.alertMessage = "Error : " + error.message;
        });
    },
  },
};
</script>

<style></style>

<!-- private String eyeOrganizationEmail;
private String patientName;
private String patientNumber;
private String patientAddress;
private String patientGender;
private int patientAge;
private String patientBloodType; -->
