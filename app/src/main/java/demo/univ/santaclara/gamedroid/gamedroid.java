package demo.univ.santaclara.gamedroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class gamedroid extends Activity implements View.OnClickListener {
    final int STARTUP_STATE = 0;
    final int PLAY_STATE = 1;
    //	Chronometer mChronometer;
    long mStartTime;
    int application_state, arrindex, selectIndex, score = 0, selectImg = 0, imgButton = 0, indexbArr = 0;
    boolean selected, bmatch;
    ;
    int items[][] = {{R.drawable.img3, R.drawable.img2, R.drawable.img1, R.drawable.img4,
            R.drawable.img5, R.drawable.img3, R.drawable.img6, R.drawable.img1,
            R.drawable.img4, R.drawable.img2, R.drawable.img6, R.drawable.img5},

            {R.drawable.img4, R.drawable.img2, R.drawable.img1, R.drawable.img3,
                    R.drawable.img1, R.drawable.img6, R.drawable.img6, R.drawable.img5,
                    R.drawable.img5, R.drawable.img2, R.drawable.img3, R.drawable.img4},

            {R.drawable.img1, R.drawable.img6, R.drawable.img6, R.drawable.img5,
                    R.drawable.img4, R.drawable.img2, R.drawable.img1, R.drawable.img3,
                    R.drawable.img5, R.drawable.img2, R.drawable.img3, R.drawable.img4},

            {R.drawable.img1, R.drawable.img6, R.drawable.img6, R.drawable.img5,
                    R.drawable.img5, R.drawable.img2, R.drawable.img3, R.drawable.img4,
                    R.drawable.img4, R.drawable.img2, R.drawable.img1, R.drawable.img3},

            {R.drawable.img1, R.drawable.img6, R.drawable.img1, R.drawable.img3,
                    R.drawable.img4, R.drawable.img2, R.drawable.img6, R.drawable.img5,
                    R.drawable.img5, R.drawable.img2, R.drawable.img3, R.drawable.img4},

            {R.drawable.img5, R.drawable.img2, R.drawable.img1, R.drawable.img3,
                    R.drawable.img4, R.drawable.img2, R.drawable.img6, R.drawable.img5,
                    R.drawable.img1, R.drawable.img6, R.drawable.img3, R.drawable.img4},

            {R.drawable.img5, R.drawable.img3, R.drawable.img2, R.drawable.img6,
                    R.drawable.img3, R.drawable.img4, R.drawable.img1, R.drawable.img5,
                    R.drawable.img1, R.drawable.img6, R.drawable.img4, R.drawable.img2},

            {R.drawable.img3, R.drawable.img4, R.drawable.img2, R.drawable.img1,
                    R.drawable.img1, R.drawable.img5, R.drawable.img3, R.drawable.img6,
                    R.drawable.img2, R.drawable.img4, R.drawable.img6, R.drawable.img5},

            {R.drawable.img4, R.drawable.img2, R.drawable.img6, R.drawable.img5,
                    R.drawable.img1, R.drawable.img6, R.drawable.img5, R.drawable.img2,
                    R.drawable.img1, R.drawable.img3, R.drawable.img3, R.drawable.img4},

            {R.drawable.img2, R.drawable.img6, R.drawable.img1, R.drawable.img2,
                    R.drawable.img5, R.drawable.img3, R.drawable.img4, R.drawable.img1,
                    R.drawable.img5, R.drawable.img3, R.drawable.img6, R.drawable.img4},

    };
    boolean bitem[] = {false, false, false, false, false, false, false, false, false, false, false, false};
    private Handler mHandler = new Handler();
    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            final long start = mStartTime;
            long millis = System.currentTimeMillis() - start;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            Log.v("GameDroid", "run @@@@@@@@ seconds : " + seconds + " millis: " + millis + "mStartTime: " + mStartTime);
            if (seconds < 10) {
                ((TextView) findViewById(R.id.timecount)).setText("" + minutes + ":0" + seconds);
            } else {
                ((TextView) findViewById(R.id.timecount)).setText("" + minutes + ":" + seconds);
            }

            mHandler.postDelayed(mUpdateTimeTask, 1000);

//    	       mHandler.postAtTime(this, start + (((minutes * 60) + seconds + 1) * 1000));
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        application_state = STARTUP_STATE;
        bmatch = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamestartupmenu);
        ((Button) findViewById(R.id.startgame)).setOnClickListener(this);
        ((Button) findViewById(R.id.exitgame)).setOnClickListener(this);
        ((Button) findViewById(R.id.about)).setOnClickListener(this);


        /*new Button.OnClickListener() {
            public void onClick(View v) {
				Log.v("GameDroid", "onClick @@@@@@@@ ");
					((ImageButton)findViewById(R.id.ImageButton01)).setImageResource(R.drawable.img6);
				//setBackgroundResource(findViewById(R.drawable.img6);
			//	applyFormat();
			}
		});
		*/
        /*
        ImageButton ibBtn2 = (ImageButton)findViewById(R.id.ImageButton02);
        ibBtn2.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.v("GameDroid", "onTouch @@@@@@@@ ");
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN ) {

                    return true;
                }

				return false;
			}
		});
		*/
//        ((ImageButton)findViewById(R.id.ImageButton01)).setOnClickListener(this);
        //      ((ImageButton)findViewById(R.id.ImageButton02)).setOnClickListener(this);


/*
//        Create an AdWhirlLayout. Make sure that this code is called in the main thread.
        LinearLayout ll = new LinearLayout(this);
        com.adwhirl.AdWhirlLayout adWhirlLayout = new com.adwhirl.AdWhirlLayout(this, "AdWhirl SDK Key");
    	RelativeLayout.LayoutParams adWhirlLayoutParams = new RelativeLayout.LayoutParams(320, 52);
//    	R.layout.addView(adWhirlLayout, adWhirlLayoutParams);
    	ll.addView(adWhirlLayout, adWhirlLayoutParams);
*/
    }

    public void onPause() {
        super.onPause();
        Log.v("GameDroid", "onPause() remove callback.");
        mHandler.removeCallbacks(mUpdateTimeTask);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.v("GameDroid", "onKeyDown( " + keyCode + ") ( " + event + " )");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            switch (application_state) {
                case PLAY_STATE:
                    application_state = STARTUP_STATE;
                    Log.v("GameDroid", "KeyEvent.KEYCODE_BACK - PLAY_STATE -  remove callback.");
                    mHandler.removeCallbacks(mUpdateTimeTask);
                    setContentView(R.layout.gamestartupmenu);
                    ((Button) findViewById(R.id.startgame)).setOnClickListener(this);
                    ((Button) findViewById(R.id.exitgame)).setOnClickListener(this);
                    return true;
                case STARTUP_STATE:
                    Log.v("GameDroid", "KeyEvent.KEYCODE_BACK - STARTUP_STATE ");
                    //you can close your app/activity by calling this.finish().
                    //Cleanup should be done within onPause(...) / onFreeze(...) / onDestroy(...) depending on what you want to do.
                    this.finish();
                    return true;

            }

        }
        return false;
    }

    public void onClick(View view) {
        Log.v("GameDroid", "onClick @@@@@@@@ onClick");

        if (bmatch) {
            if (view == ((Button) findViewById(R.id.tryagain))) {
                if (score >= 120) {
                    score = 0;
                    bmatch = false;
                    application_state = STARTUP_STATE;
                    Log.v("GameDroid", "KeyEvent.KEYCODE_BACK - PLAY_STATE -  remove callback.");
                    mHandler.removeCallbacks(mUpdateTimeTask);
                    setContentView(R.layout.gamestartupmenu);
                    ((Button) findViewById(R.id.startgame)).setOnClickListener(this);
                    ((Button) findViewById(R.id.exitgame)).setOnClickListener(this);
                } else {
                    bmatch = false;
                    ((ImageButton) findViewById(imgButton)).setImageResource(R.drawable.blank); //R.drawable.img6);
                    ((ImageButton) findViewById(selectImg)).setImageResource(R.drawable.blank); //R.drawable.img6);
                    ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    selectImg = 0;
                }
            }
        } else {
            if (view == (LinearLayout) findViewById(R.layout.gamestartdisplay)) {
                Log.v("GameDroid", "R.layout.gamestartdisplay @@@@@@@@ onClick");
            } else if (view == (Button) findViewById(R.id.startgame)) {
                Log.v("GameDroid", "onClick @@@@@@@@ StartGameImageButton");
                application_state = PLAY_STATE;
                setContentView(R.layout.gamestartdisplay);
                ((ImageButton) findViewById(R.id.ImageButton01)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton02)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton03)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton04)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton05)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton06)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton07)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton08)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton09)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton010)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton011)).setOnClickListener(this);
                ((ImageButton) findViewById(R.id.ImageButton012)).setOnClickListener(this);
                ((Button) findViewById(R.id.tryagain)).setOnClickListener(this);
                //	        ((Button)findViewById(R.id.pickagain)).setEnabled(false);
                selected = false;
                bmatch = false;
                selectIndex = score = selectImg = 0;
                mStartTime = System.currentTimeMillis();
                arrindex = (int) (mStartTime % 10);
                Log.v("GameDroid", "StartGameImageButton() arrindex : " + arrindex);
                mHandler.removeCallbacks(mUpdateTimeTask);
                mHandler.postDelayed(mUpdateTimeTask, 100);
                bitem[0] = false;
                bitem[1] = false;
                bitem[2] = false;
                bitem[3] = false;
                bitem[4] = false;
                bitem[5] = false;
                bitem[6] = false;
                bitem[7] = false;
                bitem[8] = false;
                bitem[9] = false;
                bitem[10] = false;
                bitem[11] = false;

		 /*
    //	        LinearLayout layout  = (LinearLayout) findViewById (R.layout.gamestartdisplay);
	//	        ((LinearLayout)view).addView(mChronometer);

	//	        Context context = this.getApplicationContext();

		        LayoutInflater inflater = ((Activity) this.getApplicationContext()).getLayoutInflater();
		        view = inflater.inflate(R.layout.gamestartdisplay, null);

		        int stoppedMilliseconds = 0;

		        String chronoText = mChronometer.getText().toString();
		        String array[] = chronoText.split(":");
		        if (array.length == 2) {
		          stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000
		              + Integer.parseInt(array[1]) * 1000;
		        } else if (array.length == 3) {
		          stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000
		              + Integer.parseInt(array[1]) * 60 * 1000
		              + Integer.parseInt(array[2]) * 1000;
		        }

		        mChronometer = new Chronometer(this);
		        Log.v("GameDroid", "mChronometer created @@@@@@@@ ");
		        mChronometer.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
		        Log.v("GameDroid", "mChronometer setBase() @@@@@@@@ ");
		        mChronometer.start();
		        Log.v("GameDroid", "mChronometer start() @@@@@@@@ ");
	*/
            } else if (view == (Button) findViewById(R.id.exitgame)) {
                this.finish();
            } else if (view == (Button) findViewById(R.id.about)) {
                Intent myIntent = new Intent(gamedroid.this, WebActivity.class);
                gamedroid.this.startActivity(myIntent);
            } else if (view == (ImageButton) findViewById(R.id.ImageButton01)) {
                //	        ((Button)findViewById(R.id.pickagain)).setEnabled(true);
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton01 before IF " + bitem[0]);

                if ((bitem[0] == false) && (selectImg != R.id.ImageButton01)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");
                        if (selectIndex == items[arrindex][0]) {
                            Log.v("GameDroid", "onClick @@@@@@@@ matched ");

                            score += 20;
                            bitem[0] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton01)).setImageResource(items[arrindex][0]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }
                        } else {
                            Log.v("GameDroid", "onClick @@@@@@@@ not matched ");
                            ((ImageButton) findViewById(R.id.ImageButton01)).setImageResource(items[arrindex][0]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton01;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@ not selected ImageButton01");
                        indexbArr = 0;
                        selected = true;
                        selectIndex = items[arrindex][0];
                        selectImg = R.id.ImageButton01;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton01");
                        ((ImageButton) findViewById(R.id.ImageButton01)).setImageResource(items[arrindex][0]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton02)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton02");
                //			((ImageButton)findViewById(R.id.ImageButton02)).setImageResource( items[arrindex][1]);//R.drawable.img3);
                if ((bitem[1] == false) && (selectImg != R.id.ImageButton02)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][1]) {
                            score += 20;
                            bitem[1] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton02)).setImageResource(items[arrindex][1]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton02)).setImageResource(items[arrindex][1]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton02;
                            // selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@  not selected ImageButton01");
                        indexbArr = 1;
                        selected = true;
                        selectIndex = items[arrindex][1];
                        selectImg = R.id.ImageButton02;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton01");
                        ((ImageButton) findViewById(R.id.ImageButton02)).setImageResource(items[arrindex][1]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }

            } else if (view == (ImageButton) findViewById(R.id.ImageButton03)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton03");
                //			((ImageButton)findViewById(R.id.ImageButton03)).setImageResource(items[arrindex][2]); //R.drawable.img4);
                if ((bitem[2] == false) && (selectImg != R.id.ImageButton03)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][2]) {
                            score += 20;
                            bitem[2] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton03)).setImageResource(items[arrindex][2]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton03)).setImageResource(items[arrindex][2]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton03;
                            //selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@  not selected ImageButton01");
                        indexbArr = 2;
                        selected = true;
                        selectIndex = items[arrindex][2];
                        selectImg = R.id.ImageButton03;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton03");
                        ((ImageButton) findViewById(R.id.ImageButton03)).setImageResource(items[arrindex][2]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }

            } else if (view == (ImageButton) findViewById(R.id.ImageButton04)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton04 " + bitem[3]);
                //			((ImageButton)findViewById(R.id.ImageButton04)).setImageResource(items[arrindex][3]); //R.drawable.img5);
                if ((bitem[3] == false) && (selectImg != R.id.ImageButton04)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][3]) {
                            score += 20;
                            bitem[3] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton04)).setImageResource(items[arrindex][3]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }
                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton04)).setImageResource(items[arrindex][3]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton04;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@  not selected ImageButton01");
                        indexbArr = 3;
                        selected = true;
                        selectIndex = items[arrindex][3];
                        selectImg = R.id.ImageButton04;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton04");
                        ((ImageButton) findViewById(R.id.ImageButton04)).setImageResource(items[arrindex][3]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton05)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton05 ");
                //			((ImageButton)findViewById(R.id.ImageButton05)).setImageResource( items[arrindex][4] ); //R.drawable.img1);
                if ((bitem[4] == false) && (selectImg != R.id.ImageButton05)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][4]) {
                            score += 20;
                            bitem[4] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton05)).setImageResource(items[arrindex][4]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton05)).setImageResource(items[arrindex][4]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton05;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@  not selected ImageButton01");
                        indexbArr = 4;
                        selected = true;
                        selectIndex = items[arrindex][4];
                        selectImg = R.id.ImageButton05;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton05");
                        ((ImageButton) findViewById(R.id.ImageButton05)).setImageResource(items[arrindex][4]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton06)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton06 ");
                //			((ImageButton)findViewById(R.id.ImageButton06)).setImageResource( items[arrindex][5]); //R.drawable.img2);
                if ((bitem[5] == false) && (selectImg != R.id.ImageButton06)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][5]) {
                            score += 20;
                            bitem[5] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton06)).setImageResource(items[arrindex][5]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton06)).setImageResource(items[arrindex][5]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton06;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@  not selected ImageButton01");
                        indexbArr = 5;
                        selected = true;
                        selectIndex = items[arrindex][5];
                        selectImg = R.id.ImageButton06;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton06");
                        ((ImageButton) findViewById(R.id.ImageButton06)).setImageResource(items[arrindex][5]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton07)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton07 ");
                //			((ImageButton)findViewById(R.id.ImageButton07)).setImageResource(items[arrindex][6]); //R.drawable.img6);
                if ((bitem[6] == false) && (selectImg != R.id.ImageButton07)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][6]) {
                            score += 20;
                            bitem[6] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton07)).setImageResource(items[arrindex][6]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton07)).setImageResource(items[arrindex][6]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton07;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@ not selected ImageButton01");
                        indexbArr = 6;
                        selected = true;
                        selectIndex = items[arrindex][6];
                        selectImg = R.id.ImageButton07;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton07");
                        ((ImageButton) findViewById(R.id.ImageButton07)).setImageResource(items[arrindex][6]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton08)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton08 ");
                //			((ImageButton)findViewById(R.id.ImageButton08)).setImageResource(items[arrindex][7]); //R.drawable.img4);
                if ((bitem[7] == false) && (selectImg != R.id.ImageButton08)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][7]) {
                            score += 20;
                            bitem[7] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton08)).setImageResource(items[arrindex][7]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton08)).setImageResource(items[arrindex][7]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton08;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@ not  selected ImageButton01");

                        selected = true;
                        selectIndex = items[arrindex][7];
                        indexbArr = 7;
                        selectImg = R.id.ImageButton08;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton08");
                        ((ImageButton) findViewById(R.id.ImageButton08)).setImageResource(items[arrindex][7]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton09)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton09 ");
                //			((ImageButton)findViewById(R.id.ImageButton09)).setImageResource( items[arrindex][8]); //R.drawable.img5);
                if ((bitem[8] == false) && (selectImg != R.id.ImageButton09)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][8]) {
                            score += 20;
                            bitem[8] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton09)).setImageResource(items[arrindex][8]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton09)).setImageResource(items[arrindex][8]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton09;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@ NOT selected ImageButton01");
                        indexbArr = 8;
                        selected = false;
                        selected = true;
                        selectIndex = items[arrindex][8];
                        selectImg = R.id.ImageButton09;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton09");
                        ((ImageButton) findViewById(R.id.ImageButton09)).setImageResource(items[arrindex][8]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton010)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton010 ");
                //	((ImageButton)findViewById(R.id.ImageButton010)).setImageResource(items[arrindex][9]); // R.drawable.img3);
                if ((bitem[9] == false) && (selectImg != R.id.ImageButton010)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][9]) {
                            score += 20;
                            bitem[9] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);

                            ((ImageButton) findViewById(R.id.ImageButton010)).setImageResource(items[arrindex][9]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton010)).setImageResource(items[arrindex][9]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton010;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@  not selected ImageButton01");
                        indexbArr = 9;
                        selected = true;
                        selectIndex = items[arrindex][9];
                        selectImg = R.id.ImageButton010;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton010");
                        ((ImageButton) findViewById(R.id.ImageButton010)).setImageResource(items[arrindex][9]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }

                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton011)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton011 ");
                //			((ImageButton)findViewById(R.id.ImageButton011)).setImageResource(items[arrindex][10]); // R.drawable.img2);
                if ((bitem[10] == false) && (selectImg != R.id.ImageButton011)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][10]) {
                            score += 20;
                            bitem[10] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);
                            ((ImageButton) findViewById(R.id.ImageButton011)).setImageResource(items[arrindex][10]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton011)).setImageResource(items[arrindex][10]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton011;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@  not selected ImageButton01");
                        indexbArr = 10;
                        selected = true;
                        selectIndex = items[arrindex][10];
                        selectImg = R.id.ImageButton011;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton011");
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                        ((ImageButton) findViewById(R.id.ImageButton011)).setImageResource(items[arrindex][10]); //R.drawable.img6);
                    }
                }
            } else if (view == (ImageButton) findViewById(R.id.ImageButton012)) {
                Log.v("GameDroid", "onClick @@@@@@@@ ImageButton012 ");
                //			((ImageButton)findViewById(R.id.ImageButton012)).setImageResource(items[arrindex][11]); //R.drawable.img1);
                if ((bitem[11] == false) && (selectImg != R.id.ImageButton012)) {
                    if (selected) {
                        Log.v("GameDroid", "onClick @@@@@@@@  selected ImageButton01");

                        if (selectIndex == items[arrindex][11]) {
                            score += 20;
                            bitem[11] = true;
                            bitem[indexbArr] = true;
                            ((TextView) findViewById(R.id.scorenumber)).setText(" " + score);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.goodclick);
                            ((ImageButton) findViewById(R.id.ImageButton012)).setImageResource(items[arrindex][11]); //R.drawable.img6);
                            if (score >= 120) {
                                ((Button) findViewById(R.id.tryagain)).setText(R.string.gameover);
                                bmatch = true;
                            }


                        } else {
                            ((ImageButton) findViewById(R.id.ImageButton012)).setImageResource(items[arrindex][11]); //R.drawable.img6);
                            ((Button) findViewById(R.id.tryagain)).setText(R.string.tryagain);
                            bmatch = true;
                            imgButton = R.id.ImageButton012;
//		    				selectImg = 0;
                        }
                        selected = false;
                    } else {
                        Log.v("GameDroid", "onClick @@@@@@@@  not selected ImageButton01");
                        indexbArr = 11;
                        selected = true;
                        selectIndex = items[arrindex][11];
                        selectImg = R.id.ImageButton012;
                        Log.v("GameDroid", "onClick @@@@@@@@ ImageButton012");
                        ((ImageButton) findViewById(R.id.ImageButton012)).setImageResource(items[arrindex][11]); //R.drawable.img6);
                        ((Button) findViewById(R.id.tryagain)).setText(R.string.go);
                    }
                }
            }
        }
    }
}