package Soroban;

import javax.microedition.lcdui.*;

public class KetaTama extends Canvas implements CommandListener 
{
    
    // Keta: Haste; Tama: Conta (Haste com Contas)
    UsaKetaTama ukt;
    Command cmSair; // Comando Sair.
    int nt=5; // Número de Tamas.
    int a=10; // Largura Tama.
    int xk=10, yk=55; // Posiçao inicial do Keta.
    int wk=220, hk=2; // Dimensões do Keta.
    //hk deixa a linha do keta mais grossa
       
    Tama tama[][] = new Tama[nt][10]; // Cria Tamas.
    int it0 = nt - 1;
    int it1 = nt - 1;
    int it2 = nt - 1;
    int it3 = nt - 1;
    int it4 = nt - 1;
    int it5 = nt - 1;
    
    
    Fundo f;
    int var=0;
    
    public KetaTama(UsaKetaTama UKT)
    {
        
        ukt = UKT;
        
        try 
        {
           // Cria e adiciona os comando sair ao canvas
            cmSair = new Command("Sair", Command.EXIT, 1);
            addCommand(cmSair);
            // Liga o receptor de eventos do canvas
            this.setCommandListener(this);
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void paint(Graphics g) 
    {
        
        // Limpa pano de fundo para branco e coloca título
        g.setColor(255,255,255); // Cor branca.
        g.fillRect(0,0, getWidth(), getHeight());
        g.setColor(0,0,0); // Cor preta.
                
        f = new Fundo(g);
        f.show();
     
        //Exibir as ketas e as tamas
        int tam1=yk;
        int tam2=yk;
        
         for (int i=0; i <=1; i++)
         {
            for (int z=0; z<=4; z++) 
            {
                this.desenharTama(g, tam1, z);
                if (i == 0)
                {
                    this.desenharKeta(g, tam1, z);
                }
                            
                tam1 = tam1 + 45;
            }
         }
        
         for (int i=0; i <=1; i++)
         {
            for (int j=5; j<=9; j++)
            {
                this.desenharTama2(g, tam2, j);
                if (i == 0)
                {
                    this.desenharKeta2(g, tam2, j);
                }
                
                tam2 = tam2 + 45;
            }
         }
        
    }
        
    public void desenharTama(Graphics g, int y, int z) 
    {

        // Inicializa Tamas
        for(int k=0; k<nt; k++) 
        {
            if (tama[k][z]==null) 
            {
                tama[k][z] = new Tama(g);
                tama[k][z].setXY(xk+tama[k][z].getWidth()*k, y);
                tama[k][z].setClip(xk + k*tama[k][z].getWidth(), y,wk-3*tama[k][z].getWidth()-70, tama[k][z].getHeight());
                     
            }
        }
        
          // Mostra Tama
        for(int k=0; k < nt; k++) 
        {
            tama[k][z].show();
        }
    
    }
    
    public void desenharTama2(Graphics g, int y, int z) 
    {

        // Inicializa Tamas
        int k=0;
        if (tama[k][z]==null) 
        {
            tama[k][z] = new Tama(g);
            tama[k][z].setXY(xk+tama[k][z].getWidth()*k+180, y);
            tama[k][z].setClip(xk+180 + k*tama[k][z].getWidth(), y,wk-3*tama[k][z].getWidth(), tama[k][z].getHeight());
        }
               
        // Mostra Tama
        tama[k][z].show();
       
    
    }
    
    public void desenharKeta(Graphics g, int y, int z)
    {
        if (z == var)
        {
            g.setColor(0,200,0);
        }
        g.fillRect(xk,y-1+tama[0][z].getHeight()/2,wk-50,hk);
        g.setColor(0,0,0); // Cor preta.
        g.drawLine(xk-1,y-tama[0][z].getHeight()/2,xk-1,y+tama[0][z].getHeight()*3/2);
        g.drawLine(xk+wk-50,y-tama[0][z].getHeight()/2,xk+wk-50,y+tama[0][z].getHeight()*3/2);
        
    }
    
     public void desenharKeta2(Graphics g, int y, int z)
    {
        if (z == var)
        {
            g.setColor(0,200,0);
        }
        g.fillRect(xk+180,y-1+tama[0][z].getHeight()/2,wk-180,hk);
        g.setColor(0,0,0); // Cor preta.
        g.drawLine(xk-1+180,y-tama[0][z].getHeight()/2,xk-1+180,y+tama[0][z].getHeight()*3/2);
        g.drawLine(xk+wk,y-tama[0][z].getHeight()/2,xk+wk,y+tama[0][z].getHeight()*3/2);
        
    }
    
    protected  void keyPressed(int keyCode) 
    {
        
        switch (getGameAction(keyCode))
        {
            case LEFT: 
            {
                if (var == 0)
                {
                    tama[it0][var].jumpLeft();
                    it0++;
                    if (it0 >= nt-1) 
                    {
                        it0 = nt-1;
                    }
                    repaint();
                    break;
                }
                if (var == 1)
                {
                    tama[it1][var].jumpLeft();
                    it1++;
                    if (it1 >= nt-1) 
                    {
                        it1 = nt-1;
                    }
                    repaint();
                    break;
                }
                if (var == 2)
                {
                    tama[it2][var].jumpLeft();
                    it2++;
                    if (it2 >= nt-1) 
                    {
                        it2 = nt-1;
                    }
                    repaint();
                    break;
                }
                if (var == 3)
                {
                    tama[it3][var].jumpLeft();
                    it3++;
                    if (it3 >= nt-1) 
                    {
                        it3 = nt-1;
                    }
                    repaint();
                    break;
                }
                if (var == 4)
                {
                    tama[it4][var].jumpLeft();
                    it4++;
                    if (it4 >= nt-1) 
                    {
                        it4 = nt-1;
                    }
                    repaint();
                    break;
                }
                if ((var == 5) || (var == 6) || (var == 7) ||  (var == 8) ||  (var == 9))
                {
                    tama[0][var].jumpLeft();
                    repaint();
                    break;
                }
            }
            case RIGHT: 
            {
                if (var == 0)
                {
                    tama[it0][var].jumpRight();
                    it0--;
                    if (it0 <= 0) 
                    {
                        it0 = 0;
                    }
                    repaint();
                    break;
                }
                if (var == 1)
                {
                    tama[it1][var].jumpRight();
                    it1--;
                    if (it1 <= 0) 
                    {
                        it1 = 0;
                    }
                    repaint();
                    break;
                }
                if (var == 2)
                {
                    tama[it2][var].jumpRight();
                    it2--;
                    if (it2 <= 0) 
                    {
                        it2 = 0;
                    }
                    repaint();
                    break;
                }
                if (var == 3)
                {
                    tama[it3][var].jumpRight();
                    it3--;
                    if (it3 <= 0) 
                    {
                        it3 = 0;
                    }
                    repaint();
                    break;
                }
                if (var == 4)
                {
                    tama[it4][var].jumpRight();
                    it4--;
                    if (it4 <= 0) 
                    {
                        it4 = 0;
                    }
                    repaint();
                    break;
                }
                if ((var == 5) || (var == 6) || (var == 7) ||  (var == 8) ||  (var == 9))
                {
                    tama[0][var].jumpRight2();
                    repaint();
                    break;
                }
                      
            }
            case UP:
            {
                //analisar se estou nas ketas da direita ou da esquerda
                
               if ((var == 0) || (var == 1) || (var == 2) || (var == 3) || (var == 4))
               {
                   var = var - 1;
                   if (var<0)
                   {
                        var=4; 
                   }
                   repaint();
                   break;                
               }
               if ((var == 5) || (var == 6) || (var == 7) || (var == 8) || (var == 9))
               {
                   var = var - 1;
                   if (var<5)
                   {
                        var=9; 
                   }
                   repaint();
                   break;
               }
      
            }
            case DOWN:
            {
               if ((var == 0) || (var == 1) || (var == 2) || (var == 3) || (var == 4))
               {
                    var = var + 1;
                    if (var>4)
                    {
                        var=0; 
                    }
                    repaint();
                    break;   
               }
               if ((var == 5) || (var == 6) || (var ==7 ) || (var == 8) || (var == 9))
               {
                   var = var + 1;
                    if (var>9)
                    {
                        var=5; 
                    }
                    repaint();
                    break;
               }
            }
            case FIRE:
            {
                if(var == 0)
                {
                    var = 5;
                    repaint();
                    break;
                }
                if(var == 1)
                {
                    var = 6;
                    repaint();
                    break;
                }
                if(var == 2)
                {
                    var = 7;
                    repaint();
                    break;
                }
                if(var == 3)
                {
                    var = 8;
                    repaint();
                    break;
                }
                if(var == 4)
                {
                    var = 9;
                    repaint();
                    break;
                }
                if(var == 5)
                {
                    var = 0;
                    repaint();
                    break;
                }
                if(var == 6)
                {
                    var = 1;
                    repaint();
                    break;
                }
                if(var == 7)
                {
                    var = 2;
                    repaint();
                    break;
                }
                if(var == 8)
                {
                    var = 3;
                    repaint();
                    break;
                }
                if(var == 9)
                {
                    var = 4;
                    repaint();
                    break;
                }
            }
        }
    }
    
    protected  void keyReleased(int keyCode) 
    {
    }
    
    protected  void keyRepeated(int keyCode) 
    {
    }
    
    protected  void pointerDragged(int x, int y) 
    {
    }
    
    protected  void pointerPressed(int x, int y) 
    {
    }
    
    protected  void pointerReleased(int x, int y) 
    {
    }
    
    public void commandAction(Command c, Displayable displayable) 
    {
        
        if (c==cmSair) 
        {
            ukt.destroyApp(true);
            ukt.notifyDestroyed();
        }
        
    }
    
}
