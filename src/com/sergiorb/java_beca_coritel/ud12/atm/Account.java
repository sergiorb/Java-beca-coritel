package com.sergiorb.java_beca_coritel.ud12.atm;

public class Account {
		
		private int id;
		private String uuid;
		private double amount;
		
		public Account(int id, String uuid, double amount) {
			this.setId(id);
			this.setUuid(uuid);
			this.setAmount(amount);
		}
		
		/** @return the id */
		protected int getId() {
			return id;
		}

		/** @param id the id to set */
		protected void setId(int id) {
			this.id = id;
		}

		/** @return the uuid */
		public String getUuid() {
			return uuid;
		}

		/** @param uuid the uuid to set */
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		/** @return the amount */
		public double getAmount() {
			return amount;
		}

		/** @param amount the amount to set */
		public void setAmount(double amount) {
			this.amount = amount;
		}
	}
