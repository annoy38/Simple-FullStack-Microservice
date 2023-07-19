<template>
  <div class="container">
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <strong>{{ alertMessage }}</strong>
    </div>
    <h1>{{ AccountProfileClass.orgName }}</h1>
    <div class="container">
      <h3>Eye Organization Number : {{ AccountProfileClass.orgNumber }}</h3>
      <h3>Eye Organization Email : {{ AccountProfileClass.orgEmail }}</h3>
      <h3>Eye Organization Division : {{ AccountProfileClass.orgDivision }}</h3>
      <h3>Eye Organization Distric : {{ AccountProfileClass.orgDistric }}</h3>
      <h3>Eye Organization Upazila : {{ AccountProfileClass.orgUpazila }}</h3>
      <button type="button" class="btn btn-danger" @click="deleteAccount()">
        Delete Account
      </button>
    </div>
  </div>
</template>

<script>
import backendEyeRestApi from "@/service/backendEyeRestApi";
export default {
  name: "eyeOrgProfile",
  data() {
    return {
      AccountProfileClass: {
        orgName: "",
        orgNumber: "",
        orgEmail: "",
        orgDivision: "",
        orgDistric: "",
        orgUpazila: "",
      },
      showAlert: "",
      alertMessage: "",
    };
  },
  created() {
    this.fetchEyeProfile();
  },
  methods: {
    async fetchEyeProfile() {
      try {
        const response = await backendEyeRestApi.eyeOrgProfilePage();
        this.AccountProfileClass = response.data;
      } catch (error) {
        console.error(error);
        this.showAlert = true;
        this.alertMessage = "Failed to fetch profile data.";
      }
    },
    async deleteAccount() {
      backendEyeRestApi.deleteEyeAccount().then((response) => {
        this.showAlert = true;
        this.alertMessage = response.data;
        setTimeout(() => {
          localStorage.removeItem("token");
          localStorage.clear();
          this.$router.push("/eye-bank/eye-org-login"); // Redirect to the dashboard page
        }, 3000);
      });
    },
  },
};
</script>

<style></style>
