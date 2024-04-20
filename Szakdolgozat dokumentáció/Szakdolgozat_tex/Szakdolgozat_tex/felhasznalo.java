checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    loginUsername.setError(null);
                    String passwFromDB = snapshot.child(user).child("password").getValue(String.class);

                    if (passwFromDB.equals(passw)){
                        loginUsername.setError(null);

                        String fullnameFromDB = snapshot.child(user).child("fullname").getValue(String.class);
                        String emailFromDB = snapshot.child(user).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(user).child("username").getValue(String.class);
                        String passwordFromDB = snapshot.child(user).child("password").getValue(String.class);

                        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("fullname", fullnameFromDB);
                        editor.putString("email", emailFromDB);
                        editor.putString("username", usernameFromDB);
                        editor.putString("password", passwordFromDB);
                        editor.apply();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                        intent.putExtra("fullname", fullnameFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwFromDB);
                        intent.putExtra("email", emailFromDB);

                        startActivity(intent);
                    } else{
                        loginPassword.setError("Helytelen adatok!");
                        loginPassword.requestFocus();
                    }
                } else{
                    loginUsername.setError("Kérlek regisztrálj először!");
                    loginUsername.requestFocus();
                }
            }