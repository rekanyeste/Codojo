public Boolean checkUsername(){
        String value = loginUsername.getText().toString();
        if (value.isEmpty()){
            loginUsername.setError("A felhasználónév kötelező!");
            return false;
        } else{
            loginUsername.setError(null);
            return true;
        }
    }