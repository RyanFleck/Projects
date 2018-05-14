package SEG2106.core;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3369 modeling language!*/



// line 1 "model.ump"
public class TrafficLight implements EventHandler
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight State Machines
  public enum Status { lowTraffic, highTraffic, mediumTraffic }
  public enum StatusLowTraffic { Null, northAndSouthArrowlow, northAndSouthGreenlow, northAndSouthYellowlow, northAndSouthRedlow, westAndEastYellowlow }
  public enum StatusHighTraffic { Null, northGreenAndLeftHigh, northYellowHigh, southGreenAndLeftHigh, southYellowHigh, westGreenAndArrowHigh, westAndEastGreenHigh, westAndEastYellowHigh }
  public enum StatusMediumTraffic { Null, northGreenAndLeft, northYellowMed, southGreenAndLeft, southYellow, westAndEastGreenMed, westAndEastYellowMed }
  private Status status;
  private StatusLowTraffic statusLowTraffic;
  private StatusHighTraffic statusHighTraffic;
  private StatusMediumTraffic statusMediumTraffic;
  //------------------------
  // CONSTRUCTOR
  //------------------------
  private TrafficLightManager trafficLightManager; 
  public TrafficLight(TrafficLightManager trafficLightManager)
  {
	this.trafficLightManager = trafficLightManager;
	
	statusLowTraffic= StatusLowTraffic.Null;
	statusHighTraffic= StatusHighTraffic.Null;
	statusMediumTraffic= StatusMediumTraffic.Null;
    trafficLightManager.addEventHandler(this);
  }

//------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    if (statusLowTraffic != StatusLowTraffic.Null) { answer += "." + statusLowTraffic.toString(); }
    if (statusHighTraffic != StatusHighTraffic.Null) { answer += "." + statusHighTraffic.toString(); }
    if (statusMediumTraffic != StatusMediumTraffic.Null) { answer += "." + statusMediumTraffic.toString(); }
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public StatusLowTraffic getStatusLowTraffic()
  {
    return statusLowTraffic;
  }

  public StatusHighTraffic getStatusHighTraffic()
  {
    return statusHighTraffic;
  }

  public StatusMediumTraffic getStatusMediumTraffic()
  {
    return statusMediumTraffic;
  }

  public boolean enterLowTraffic()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    switch (aStatusLowTraffic)
    {
      case Null:
        setStatusLowTraffic(StatusLowTraffic.northAndSouthArrowlow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean exitLowTraffic()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    switch (aStatusLowTraffic)
    {
      case northAndSouthArrowlow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        wasEventProcessed = true;
        break;
      case northAndSouthGreenlow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        wasEventProcessed = true;
        break;
      case northAndSouthYellowlow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        wasEventProcessed = true;
        break;
      case northAndSouthRedlow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        wasEventProcessed = true;
        break;
      case westAndEastYellowlow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    getStatusFullName();
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    StatusMediumTraffic aStatusMediumTraffic = statusMediumTraffic;
    switch (aStatusLowTraffic)
    {
      case northAndSouthArrowlow:
        setStatusLowTraffic(StatusLowTraffic.northAndSouthGreenlow);
        wasEventProcessed = true;
        break;
      case northAndSouthGreenlow:
        setStatusLowTraffic(StatusLowTraffic.northAndSouthYellowlow);
        wasEventProcessed = true;
        break;
      case northAndSouthRedlow:
        setStatusLowTraffic(StatusLowTraffic.westAndEastYellowlow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusHighTraffic)
    {
      case northGreenAndLeftHigh:
        setStatusHighTraffic(StatusHighTraffic.northYellowHigh);
        wasEventProcessed = true;
        break;
      case southGreenAndLeftHigh:
        setStatusHighTraffic(StatusHighTraffic.southYellowHigh);
        wasEventProcessed = true;
        break;
      case westGreenAndArrowHigh:
        setStatusHighTraffic(StatusHighTraffic.westAndEastGreenHigh);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusMediumTraffic)
    {
      case northGreenAndLeft:
        setStatusMediumTraffic(StatusMediumTraffic.northYellowMed);
        wasEventProcessed = true;
        break;
      case southGreenAndLeft:
        setStatusMediumTraffic(StatusMediumTraffic.southYellow);
        wasEventProcessed = true;
        break;
      case westAndEastGreenMed:
        setStatusMediumTraffic(StatusMediumTraffic.westAndEastYellowMed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    StatusMediumTraffic aStatusMediumTraffic = statusMediumTraffic;
    switch (aStatusLowTraffic)
    {
      case northAndSouthYellowlow:
        setStatusLowTraffic(StatusLowTraffic.northAndSouthRedlow);
        wasEventProcessed = true;
        break;
      case westAndEastYellowlow:
        setStatusLowTraffic(StatusLowTraffic.northAndSouthArrowlow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusHighTraffic)
    {
      case northYellowHigh:
        setStatusHighTraffic(StatusHighTraffic.southGreenAndLeftHigh);
        wasEventProcessed = true;
        break;
      case southYellowHigh:
        setStatusHighTraffic(StatusHighTraffic.westGreenAndArrowHigh);
        wasEventProcessed = true;
        break;
      case westAndEastGreenHigh:
        setStatusHighTraffic(StatusHighTraffic.westAndEastYellowHigh);
        wasEventProcessed = true;
        break;
      case westAndEastYellowHigh:
        setStatusHighTraffic(StatusHighTraffic.northGreenAndLeftHigh);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusMediumTraffic)
    {
      case northYellowMed:
        setStatusMediumTraffic(StatusMediumTraffic.southGreenAndLeft);
        wasEventProcessed = true;
        break;
      case southYellow:
        setStatusMediumTraffic(StatusMediumTraffic.westAndEastGreenMed);
        wasEventProcessed = true;
        break;
      case westAndEastYellowMed:
        setStatusMediumTraffic(StatusMediumTraffic.northGreenAndLeft);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean enterHighTraffic()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case Null:
        setStatusHighTraffic(StatusHighTraffic.northGreenAndLeftHigh);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean exitHighTraffic()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case northGreenAndLeftHigh:
        setStatusHighTraffic(StatusHighTraffic.Null);
        wasEventProcessed = true;
        break;
      case northYellowHigh:
        setStatusHighTraffic(StatusHighTraffic.Null);
        wasEventProcessed = true;
        break;
      case southGreenAndLeftHigh:
        setStatusHighTraffic(StatusHighTraffic.Null);
        wasEventProcessed = true;
        break;
      case southYellowHigh:
        setStatusHighTraffic(StatusHighTraffic.Null);
        wasEventProcessed = true;
        break;
      case westGreenAndArrowHigh:
        setStatusHighTraffic(StatusHighTraffic.Null);
        wasEventProcessed = true;
        break;
      case westAndEastGreenHigh:
        setStatusHighTraffic(StatusHighTraffic.Null);
        wasEventProcessed = true;
        break;
      case westAndEastYellowHigh:
        setStatusHighTraffic(StatusHighTraffic.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean enterMediumTraffic()
  {
    boolean wasEventProcessed = false;
    
    StatusMediumTraffic aStatusMediumTraffic = statusMediumTraffic;
    switch (aStatusMediumTraffic)
    {
      case Null:
        setStatusMediumTraffic(StatusMediumTraffic.northGreenAndLeft);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean exitMediumTraffic()
  {
    boolean wasEventProcessed = false;
    
    StatusMediumTraffic aStatusMediumTraffic = statusMediumTraffic;
    switch (aStatusMediumTraffic)
    {
      case northGreenAndLeft:
        setStatusMediumTraffic(StatusMediumTraffic.Null);
        wasEventProcessed = true;
        break;
      case northYellowMed:
        setStatusMediumTraffic(StatusMediumTraffic.Null);
        wasEventProcessed = true;
        break;
      case southGreenAndLeft:
        setStatusMediumTraffic(StatusMediumTraffic.Null);
        wasEventProcessed = true;
        break;
      case southYellow:
        setStatusMediumTraffic(StatusMediumTraffic.Null);
        wasEventProcessed = true;
        break;
      case westAndEastGreenMed:
        setStatusMediumTraffic(StatusMediumTraffic.Null);
        wasEventProcessed = true;
        break;
      case westAndEastYellowMed:
        setStatusMediumTraffic(StatusMediumTraffic.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStatus()
  {
    switch(status)
    {
      case lowTraffic:
        exitLowTraffic();
        break;
      case highTraffic:
        exitHighTraffic();
        break;
      case mediumTraffic:
        exitMediumTraffic();
        break;
    }
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case lowTraffic:
        if (statusLowTraffic == StatusLowTraffic.Null) { setStatusLowTraffic(StatusLowTraffic.northAndSouthArrowlow); }
        break;
      case highTraffic:
        if (statusHighTraffic == StatusHighTraffic.Null) { setStatusHighTraffic(StatusHighTraffic.northGreenAndLeftHigh); }
        break;
      case mediumTraffic:
        if (statusMediumTraffic == StatusMediumTraffic.Null) { setStatusMediumTraffic(StatusMediumTraffic.northGreenAndLeft); }
        break;
    }
  }

  private void setStatusLowTraffic(StatusLowTraffic aStatusLowTraffic)
  {
    statusLowTraffic = aStatusLowTraffic;
    if (status != Status.lowTraffic && aStatusLowTraffic != StatusLowTraffic.Null) { setStatus(Status.lowTraffic); }

    // entry actions and do activities
    switch(statusLowTraffic)
    {
      case northAndSouthArrowlow:
        // line 7 "model.ump"
        trafficLightManager.northArrow();
        // line 8 "model.ump"
        trafficLightManager.southArrow();
        // line 9 "model.ump"
        trafficLightManager.westRed();
        // line 10 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthGreenlow:
        // line 14 "model.ump"
        trafficLightManager.northGreen();
        // line 15 "model.ump"
        trafficLightManager.southGreen();
        // line 16 "model.ump"
        trafficLightManager.westRed();
        // line 17 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellowlow:
        // line 21 "model.ump"
        trafficLightManager.northYellow();
        // line 22 "model.ump"
        trafficLightManager.southYellow();
        // line 23 "model.ump"
        trafficLightManager.westRed();
        // line 24 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthRedlow:
        // line 28 "model.ump"
        trafficLightManager.northRed();
        // line 29 "model.ump"
        trafficLightManager.southRed();
        // line 30 "model.ump"
        trafficLightManager.westGreen();
        // line 31 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellowlow:
        // line 35 "model.ump"
        trafficLightManager.northRed();
        // line 36 "model.ump"
        trafficLightManager.southRed();
        // line 37 "model.ump"
        trafficLightManager.westYellow();
        // line 38 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  private void setStatusHighTraffic(StatusHighTraffic aStatusHighTraffic)
  {
    statusHighTraffic = aStatusHighTraffic;
    if (status != Status.highTraffic && aStatusHighTraffic != StatusHighTraffic.Null) { setStatus(Status.highTraffic); }

    // entry actions and do activities
    switch(statusHighTraffic)
    {
      case northGreenAndLeftHigh:
        // line 44 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 45 "model.ump"
        trafficLightManager.southRed();
        // line 46 "model.ump"
        trafficLightManager.westRed();
        // line 47 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northYellowHigh:
        // line 51 "model.ump"
        trafficLightManager.northYellow();
        // line 52 "model.ump"
        trafficLightManager.southRed();
        // line 53 "model.ump"
        trafficLightManager.westRed();
        // line 54 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southGreenAndLeftHigh:
        // line 58 "model.ump"
        trafficLightManager.northRed();
        // line 59 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 60 "model.ump"
        trafficLightManager.westRed();
        // line 61 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southYellowHigh:
        // line 65 "model.ump"
        trafficLightManager.northRed();
        // line 66 "model.ump"
        trafficLightManager.southYellow();
        // line 67 "model.ump"
        trafficLightManager.westRed();
        // line 68 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westGreenAndArrowHigh:
        // line 72 "model.ump"
        trafficLightManager.northRed();
        // line 73 "model.ump"
        trafficLightManager.southRed();
        // line 74 "model.ump"
        trafficLightManager.westGreenAndArrow();
        // line 75 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westAndEastGreenHigh:
        // line 79 "model.ump"
        trafficLightManager.northRed();
        // line 80 "model.ump"
        trafficLightManager.southRed();
        // line 81 "model.ump"
        trafficLightManager.westGreen();
        // line 82 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellowHigh:
        // line 86 "model.ump"
        trafficLightManager.northRed();
        // line 87 "model.ump"
        trafficLightManager.southRed();
        // line 88 "model.ump"
        trafficLightManager.westYellow();
        // line 89 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  private void setStatusMediumTraffic(StatusMediumTraffic aStatusMediumTraffic)
  {
    statusMediumTraffic = aStatusMediumTraffic;
    if (status != Status.mediumTraffic && aStatusMediumTraffic != StatusMediumTraffic.Null) { setStatus(Status.mediumTraffic); }

    // entry actions and do activities
    switch(statusMediumTraffic)
    {
      case northGreenAndLeft:
        // line 95 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 96 "model.ump"
        trafficLightManager.southRed();
        // line 97 "model.ump"
        trafficLightManager.westRed();
        // line 98 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northYellowMed:
        // line 102 "model.ump"
        trafficLightManager.northYellow();
        // line 103 "model.ump"
        trafficLightManager.southRed();
        // line 104 "model.ump"
        trafficLightManager.westRed();
        // line 105 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southGreenAndLeft:
        // line 109 "model.ump"
        trafficLightManager.northRed();
        // line 110 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 111 "model.ump"
        trafficLightManager.westRed();
        // line 112 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southYellow:
        // line 116 "model.ump"
        trafficLightManager.northRed();
        // line 117 "model.ump"
        trafficLightManager.southYellow();
        // line 118 "model.ump"
        trafficLightManager.westRed();
        // line 119 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westAndEastGreenMed:
        // line 123 "model.ump"
        trafficLightManager.northRed();
        // line 124 "model.ump"
        trafficLightManager.southRed();
        // line 125 "model.ump"
        trafficLightManager.westGreen();
        // line 126 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellowMed:
        // line 130 "model.ump"
        trafficLightManager.northRed();
        // line 131 "model.ump"
        trafficLightManager.southRed();
        // line 132 "model.ump"
        trafficLightManager.westYellow();
        // line 133 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }


  public void delete()
  {}

}