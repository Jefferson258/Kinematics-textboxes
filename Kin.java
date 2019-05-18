public class Kin
{
    private double a, vi, vf, disp, time;
    
    public Kin(double acceleration, double initialvelocity, double finalvelocity, double displacement, double t)
    {
        a = acceleration;
        vi = initialvelocity;
        vf = finalvelocity;
        disp = displacement;
        time = t;
    }
    
    public double solveForAcceleration()
    {
        if(vf != Double.POSITIVE_INFINITY && vi != Double.POSITIVE_INFINITY && disp != Double.POSITIVE_INFINITY)
            return ((vf * vf) - (vi * vi))/(2 * disp);
        else if(disp != Double.POSITIVE_INFINITY && vi != Double.POSITIVE_INFINITY && time != Double.POSITIVE_INFINITY)
            return (2*(disp - (vi * time)))/(time * time);
        else
            return (vf - vi)/time;
    }
    
    public double solveForTime()
    {
        if(vi != Double.POSITIVE_INFINITY && a != Double.POSITIVE_INFINITY && disp != Double.POSITIVE_INFINITY)
            return Math.abs((-vi + Math.sqrt(vi * vi + 4 * a * disp))/a);
        else
            return Math.abs((vf - vi)/a);
    }
    
    public double solveForVf()
    {
        if(vi != Double.POSITIVE_INFINITY && a != Double.POSITIVE_INFINITY && disp != Double.POSITIVE_INFINITY)
            return Math.sqrt(vi * vi + 2 * a * disp);     
        else
            return vi + a * time;
    }
    
    public double solveForVi()
    {
        if(vf != Double.POSITIVE_INFINITY && a != Double.POSITIVE_INFINITY && disp != Double.POSITIVE_INFINITY)
            return Math.sqrt(vf * vf - 2 * a * disp);
        else if(disp != Double.POSITIVE_INFINITY && a != Double.POSITIVE_INFINITY && time != Double.POSITIVE_INFINITY)
            return ((disp - .5 * a * time * time)/time);
        else
            return vf - a * time;
    }
    
    public double solveForDisplacement()
    {
        if(a != Double.POSITIVE_INFINITY && time != Double.POSITIVE_INFINITY && vi != Double.POSITIVE_INFINITY)
            return .5 * a * time * time + vi * time;
        else
            return (vf * vf - vi * vi)/(2 * a);
    }
}