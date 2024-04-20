public void checkUser(){
        String user = loginUsername.getText().toString().trim();
        String passw = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(user);