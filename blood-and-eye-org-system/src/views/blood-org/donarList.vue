<template>
  <div class="container">
    <h1>Donor List</h1>
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      <strong>{{ alertMessage }}</strong>
    </div>
    <div class="container">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Donar Name</th>
            <th scope="col">Donar Email</th>
            <th scope="col">Donar Age</th>
            <th scope="col">Donar Gender</th>
            <th scope="col">Donar Address</th>
            <th scope="col">Donar Blood Group</th>
            <th scope="col">Blood Donate Date</th>
            <th scope="col">Donar Status</th>
            <th scope="col">Delete Donor</th>
          </tr>
        </thead>
        <tbody>
          <tr
            class="table-success"
            v-for="donor in DonorsList"
            :key="donor.DonarInfoClass.donarId"
          >
            <th scope="row">{{ donor.DonarInfoClass.donarName }}</th>
            <td>{{ donor.DonarInfoClass.donarEmail }}</td>
            <td>{{ donor.DonarInfoClass.donarAge }}</td>
            <td>{{ donor.DonarInfoClass.donarGender }}</td>
            <td>{{ donor.DonarInfoClass.donarAddress }}</td>
            <td>{{ donor.DonarInfoClass.donarBloodType }}</td>
            <td>{{ donor.DonarInfoClass.localDate }}</td>
            <td>{{ donor.DonarInfoClass.status }}</td>
            <td>
              <button
                type="button"
                @click="deleteDonor(donor.DonarInfoClass.donarId)"
                class="btn btn-danger"
              >
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "donarList",
  data() {
    return {
      DonorsList: [],
      showAlert: "",
      alertMessage: "",
    };
  },
  created() {
    this.fetchDonorsInfo();
  },
  methods: {
    async fetchDonorsInfo() {
      try {
        const response = await backendRestApi.donorsList();
        this.DonorsList = response.data.map((donor) => ({
          DonarInfoClass: {
            donarId: donor.donarId || "",
            bloodOrganizationId: donor.bloodOrganizationId || "",
            donarName: donor.donarName || "",
            donarEmail: donor.donarEmail || "",
            donarAge: donor.donarAge || "",
            donarGender: donor.donarGender || "",
            donarAddress: donor.donarAddress || "",
            donarBloodType: donor.donarBloodType || "",
            localDate: donor.localDate || "",
            status: donor.status || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },

    async deleteDonor(donorId) {
      try {
        const response = await backendRestApi.deleteDonorInfo(donorId);
        this.showAlert = true;
        this.alertMessage = response.data;
        setTimeout(() => {
          this.$router.push("/blood-org-deshboard/blood-donor-list");
          this.showAlert = false;
          this.alertMessage = ""; // Redirect to the dashboard page
        }, 3000);
      } catch (error) {
        console.error("Error deleting donor:", error);
      }
    },
  },
};
</script>

<style></style>
