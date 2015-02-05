package com.wm.zpfallon.fifateams;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class ResultActivity extends ActionBarActivity {
    TextToSpeech ttobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Team> teamList = ((TeamList) this.getApplication()).getTeamList();
        setContentView(R.layout.activity_result);
        setTitle("FifaTeams");
        //Get references to the widgets
        ImageView topFlag = (ImageView) findViewById(R.id.imageView17);
        ImageView bottomFlag = (ImageView) findViewById(R.id.imageView18);
        TextView topName = (TextView) findViewById(R.id.textView9);
        TextView bottomName = (TextView) findViewById(R.id.textView10);
        TextView topAtt = (TextView) findViewById(R.id.textView3);
        TextView bottomAtt = (TextView) findViewById(R.id.textView6);
        TextView topMid = (TextView) findViewById(R.id.textView4);
        TextView bottomMid = (TextView) findViewById(R.id.textView7);
        TextView topDef = (TextView) findViewById(R.id.textView5);
        TextView bottomDef = (TextView) findViewById(R.id.textView8);
        //Select two random non matching numbers
        Random r = new Random();
        int one = r.nextInt(teamList.size());
        int two = r.nextInt(teamList.size());
        while (one == two){
            two = r.nextInt(teamList.size());
        }
        final Team topTeam = teamList.get(one);
        final Team bottomTeam = teamList.get(two);
        //Set Text Fields
        topName.setText(topTeam.toString());
        bottomName.setText(bottomTeam.toString());
        topAtt.setText("Att: "+topTeam.getAtt());
        bottomAtt.setText("Att: "+bottomTeam.getAtt());
        topMid.setText("Mid: "+topTeam.getMid());
        bottomMid.setText("Mid "+bottomTeam.getMid());
        topDef.setText("Def: "+topTeam.getDef());
        bottomDef.setText("Def: "+bottomTeam.getDef());
        topFlag.setImageResource(imageKey(topTeam));
        bottomFlag.setImageResource(imageKey(bottomTeam));
        ttobj = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            ttobj.setLanguage(Locale.UK);
                            String toSpeak = topTeam.toString() + ", versus, " + bottomTeam.toString();
                            ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });



    }


    private int imageKey(Team team){
        String name = team.toString();
        if(name.equals("Argentina")){
            return R.drawable.argentina;
        }else if(name.equals("Australia")){
            return R.drawable.australia;
        }else if(name.equals("Austria")){
            return R.drawable.austria;
        }else if(name.equals("Belgium")){
            return R.drawable.belgium;
        }else if(name.equals("Bolivia")){
            return R.drawable.bolivia;
        }else if(name.equals("Brazil")){
            return R.drawable.brazil;
        }else if(name.equals("Bulgaria")){
            return R.drawable.bulgaria;
        }else if(name.equals("Cameroon")){
            return R.drawable.cameroon;
        }else if(name.equals("Chile")){
            return R.drawable.chile;
        }else if(name.equals("Colombia")){
            return R.drawable.colombia;
        }else if(name.equals("Cote d'Ivoire")){
            return R.drawable.cotedvoire;
        }else if(name.equals("Czech Republic")){
            return R.drawable.czechrepublic;
        }else if(name.equals("Denmark")){
            return R.drawable.denmark;
        }else if(name.equals("Ecuador")){
            return R.drawable.ecuador;
        }else if(name.equals("Egypt")){
            return R.drawable.egypt;
        }else if(name.equals("England")){
            return R.drawable.england;
        }else if(name.equals("Finland")){
            return R.drawable.finland;
        }else if(name.equals("France")){
            return R.drawable.france;
        }else if(name.equals("Germany")){
            return R.drawable.germany;
        }else if(name.equals("Greece")){
            return R.drawable.greece;
        }else if(name.equals("Hungary")){
            return R.drawable.hungary;
        }else if(name.equals("India")){
            return R.drawable.india;
        }else if(name.equals("Ireland")){
            return R.drawable.ireland;
        }else if(name.equals("Italy")){
            return R.drawable.italy;
        }else if(name.equals("Korea Republic")){
            return R.drawable.korearepublic;
        }else if(name.equals("Mexico")){
            return R.drawable.mexico;
        }else if(name.equals("Netherlands")){
            return R.drawable.netherlands;
        }else if(name.equals("New Zealand")){
            return R.drawable.newzealand;
        }else if(name.equals("Northern Ireland")){
            return R.drawable.northernireland;
        }else if(name.equals("Norway")){
            return R.drawable.norway;
        }else if(name.equals("Paraguay")){
            return R.drawable.paraguay;
        }else if(name.equals("Peru")){
            return R.drawable.peru;
        }else if(name.equals("Poland")){
            return R.drawable.poland;
        }else if(name.equals("Portugal")){
            return R.drawable.portugal;
        }else if(name.equals("Romania")){
            return R.drawable.romania;
        }else if(name.equals("Russia")){
            return R.drawable.russia;
        }else if(name.equals("Scotland")){
            return R.drawable.scotland;
        }else if(name.equals("Slovenia")){
            return R.drawable.slovenia;
        }else if(name.equals("South Africa")){
            return R.drawable.southafrica;
        }else if(name.equals("Spain")){
            return R.drawable.spain;
        }else if(name.equals("Sweden")){
            return R.drawable.sweden;
        }else if(name.equals("Switzerland")){
            return R.drawable.switzerland;
        }else if(name.equals("Turkey")){
            return R.drawable.turkey;
        }else if(name.equals("United States")){
            return R.drawable.unitedstates;
        }else if(name.equals("Uruguay")){
            return R.drawable.uruguay;
        }else if(name.equals("Venezuela")){
            return R.drawable.venezuela;
        }else if(name.equals("Wales")){
            return R.drawable.wales;
        }else{
            Log.v("Result","Returned 0 in imageKey");
            return 0;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
