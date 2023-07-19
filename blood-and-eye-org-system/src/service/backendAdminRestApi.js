import axios from "@/axios";

class adminRestApi {
  async countBloodOrg() {
    try {
      return await axios.get("api/admin/total-number-of-blood-organization");
    } catch (error) {
      console.log(error);
    }
  }

  async countBloodDonor() {
    try {
      return await axios.get("api/admin/total-number-of-blood-donors");
    } catch (error) {
      console.log(error);
    }
  }

  async countEyeOrg() {
    try {
      return await axios.get("api/admin/total-number-of-eye-organization");
    } catch (error) {
      console.log(error);
    }
  }

  async countEyeDonor() {
    try {
      return await axios.get("api/admin/total-number-of-eye-donors");
    } catch (error) {
      console.log(error);
    }
  }

  async deliveryReqList() {
    try {
      return await axios.get("api/admin/get-all-delivery-request");
    } catch (error) {
      console.log(error);
    }
  }

  async updateDeliveryStatus(id, uStatus) {
    try {
      return await axios.get("api/admin/update-delivery-request", {
        params: {
          deliverId: id,
          status: uStatus,
        },
      });
    } catch (error) {
      console.log(error);
    }
  }
}
export default new adminRestApi();
