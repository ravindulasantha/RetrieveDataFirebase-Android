FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference reference = database.getReference("your_node_path");

reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // Retrieve the data from the dataSnapshot
        String dailyI = dataSnapshot.child("dailyIncome").getValue(String.class);
        String totalB = dataSnapshot.child("totalBalance").getValue(String.class);

        // Update the TextViews with the retrieved data
        totalbalance.setText(dailyI);
        dailyincome.setText(totalB);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // Handle any errors that occur during the data retrieval
        Log.e("Firebase", "Error retrieving data from Firebase: " + databaseError.getMessage());
    }
});
