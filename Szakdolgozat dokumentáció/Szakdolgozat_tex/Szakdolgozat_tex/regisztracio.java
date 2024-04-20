registerButton.setOnClickListener(view -> {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");

            String fname = fullname.getText().toString();
            String uname = username.getText().toString();
            String pwd = password.getText().toString();
            String emailAdd = email.getText().toString();

            Users users = new Users(fname, uname, pwd, emailAdd);
            reference.child(uname).setValue(users);

            Toast.makeText(RegisterActivity.this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        });