VERSION 5.00
Object = "{648A5603-2C6E-101B-82B6-000000000014}#1.1#0"; "MSCOMM32.OCX"
Begin VB.Form Form1 
   Caption         =   "GSM MESSAGER"
   ClientHeight    =   8295
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   15180
   LinkTopic       =   "Form1"
   ScaleHeight     =   8295
   ScaleWidth      =   15180
   Begin VB.Frame Frame3 
      BackColor       =   &H8000000C&
      Height          =   7215
      Left            =   3960
      TabIndex        =   21
      Top             =   120
      Width           =   9255
      Begin VB.TextBox Text2 
         Height          =   5655
         Left            =   4680
         MultiLine       =   -1  'True
         ScrollBars      =   2  'Vertical
         TabIndex        =   25
         Top             =   840
         Width           =   4335
      End
      Begin VB.TextBox Text1 
         Height          =   5655
         Left            =   240
         MultiLine       =   -1  'True
         ScrollBars      =   2  'Vertical
         TabIndex        =   24
         Top             =   840
         Width           =   4335
      End
      Begin VB.CommandButton Command12 
         Caption         =   "CLEAR"
         Height          =   375
         Left            =   240
         TabIndex        =   23
         Top             =   6600
         Width           =   8775
      End
      Begin VB.CommandButton Command14 
         Caption         =   "Emulate Message Received"
         Height          =   375
         Left            =   240
         TabIndex        =   22
         Top             =   360
         Width           =   8775
      End
   End
   Begin VB.Frame Frame2 
      BackColor       =   &H8000000C&
      Caption         =   "Manual Interface"
      Height          =   5295
      Left            =   120
      TabIndex        =   7
      Top             =   2040
      Width           =   3735
      Begin VB.CommandButton Command1 
         Caption         =   "AT"
         Height          =   495
         Left            =   240
         TabIndex        =   18
         Top             =   360
         Width           =   1575
      End
      Begin VB.CommandButton Command3 
         Caption         =   "CHECK"
         Height          =   495
         Left            =   1920
         TabIndex        =   17
         Top             =   360
         Width           =   1455
      End
      Begin VB.CommandButton Command4 
         Caption         =   "SIGNAL STRENGTH"
         Height          =   495
         Left            =   240
         TabIndex        =   16
         Top             =   960
         Width           =   1575
      End
      Begin VB.CommandButton Command5 
         Caption         =   "SEND MESSAGE"
         Height          =   375
         Left            =   240
         TabIndex        =   15
         Top             =   2520
         Width           =   3135
      End
      Begin VB.TextBox TextMessage 
         Height          =   495
         Left            =   240
         MultiLine       =   -1  'True
         TabIndex        =   14
         Text            =   "Form1.frx":0000
         Top             =   1920
         Width           =   3135
      End
      Begin VB.TextBox TextMessageTo 
         Height          =   285
         Left            =   1560
         TabIndex        =   13
         Text            =   "+919860405018"
         Top             =   1560
         Width           =   1815
      End
      Begin VB.CommandButton Command7 
         Caption         =   "TEXT FORMAT"
         Height          =   495
         Left            =   1920
         TabIndex        =   12
         Top             =   960
         Width           =   1455
      End
      Begin VB.CommandButton Command8 
         Caption         =   "IMMEDIATE"
         Height          =   375
         Left            =   240
         TabIndex        =   11
         Top             =   3000
         Width           =   3135
      End
      Begin VB.TextBox TextLocation 
         Height          =   285
         Left            =   1800
         TabIndex        =   10
         Text            =   $"Form1.frx":000A
         Top             =   3720
         Width           =   1575
      End
      Begin VB.CommandButton Command10 
         Caption         =   "READ"
         Height          =   375
         Left            =   240
         TabIndex        =   9
         Top             =   4080
         Width           =   3135
      End
      Begin VB.CommandButton Command11 
         Caption         =   "DELETE"
         Height          =   375
         Left            =   240
         TabIndex        =   8
         Top             =   4560
         Width           =   3135
      End
      Begin VB.Label Label2 
         BorderStyle     =   1  'Fixed Single
         Caption         =   "To"
         Height          =   255
         Left            =   240
         TabIndex        =   20
         Top             =   1560
         Width           =   1215
      End
      Begin VB.Label Label3 
         BorderStyle     =   1  'Fixed Single
         Caption         =   "Location"
         Height          =   255
         Left            =   240
         TabIndex        =   19
         Top             =   3720
         Width           =   1455
      End
   End
   Begin VB.Timer Timer1 
      Enabled         =   0   'False
      Interval        =   2500
      Left            =   1200
      Top             =   1680
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H00808000&
      Height          =   1455
      Left            =   120
      TabIndex        =   0
      Top             =   120
      Width           =   3735
      Begin VB.CommandButton Command2 
         Caption         =   "EXIT"
         Height          =   375
         Left            =   1920
         TabIndex        =   6
         Top             =   600
         Width           =   1695
      End
      Begin VB.CommandButton Command13 
         Caption         =   "CONNECT"
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   3
         Top             =   600
         Width           =   1695
      End
      Begin VB.ComboBox Combo1 
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   315
         ItemData        =   "Form1.frx":0011
         Left            =   1920
         List            =   "Form1.frx":0051
         Style           =   2  'Dropdown List
         TabIndex        =   2
         Top             =   240
         Width           =   1695
      End
      Begin VB.Label Label4 
         Alignment       =   1  'Right Justify
         BorderStyle     =   1  'Fixed Single
         Caption         =   "COM PORT"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   9
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   120
         TabIndex        =   1
         Top             =   240
         Width           =   1695
      End
   End
   Begin MSCommLib.MSComm MSComm1 
      Left            =   480
      Top             =   1560
      _ExtentX        =   1005
      _ExtentY        =   1005
      _Version        =   393216
      CommPort        =   3
      DTREnable       =   -1  'True
      RThreshold      =   1
   End
   Begin VB.Label Label7 
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   120
      TabIndex        =   5
      Top             =   1560
      Width           =   735
   End
   Begin VB.Label Label6 
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   960
      TabIndex        =   4
      Top             =   1560
      Width           =   2895
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim stat As Integer, nextStat As Integer, waitCount As Integer
Dim initFlag As Boolean, errorFlag As Boolean, recvFlag As Boolean, sFlag As Boolean, sendFlag As Boolean
Dim inData As String
Dim recvCnt As Integer
Dim msgText As String, msgFrom As String, msgTime As String
Dim inArray(500) As String
Dim portOpen As Boolean


Private Sub Command1_Click()
'MSComm1.Output = "AT" & Chr(13) & Chr(10)
'MSComm1.PortOpen = True
MSComm1.Output = Chr(Asc("A"))
MSComm1.Output = Chr(Asc("T"))
MSComm1.Output = Chr(13)
MSComm1.Output = Chr(10)
End Sub

Private Sub Command10_Click()
MSComm1.Output = "AT+CMGR=" & TextLocation.Text & Chr(13) & Chr(10)

End Sub

Private Sub Command11_Click()
MSComm1.Output = "AT+CMGD=" & TextLocation.Text & Chr(13) & Chr(10)

End Sub

Private Sub Command12_Click()
Text1.Text = ""
Text2.Text = ""
End Sub

Private Sub Command13_Click()
MSComm1.CommPort = Combo1.ListIndex + 1
MSComm1.portOpen = True
waitCount = 0
stat = 0
nextStat = 0
errorFlag = False
initFlag = False
Timer1.Enabled = True

End Sub

Private Sub Command14_Click()
Dim i As Integer, s() As String, info As String, msg As String
Dim s2() As String, s3() As String, msgnum As String
Dim fnum As Integer, MyMSG As String, ReplyMsg As String
Dim cnt As Integer, ReplyNum As String, writeStr As String
Dim outFnamedt As String
Dim x() As String

'List1.Clear
Text2.Text = ""
For i = 0 To recvCnt - 1
'    List1.AddItem inArray(i)
    Text2.Text = Text2.Text & inArray(i)
Next
Dim test As String
test = Mid(Text2.Text, 3, 4)
If test = "+CMT" Then
    s = Split(Text2.Text, Chr(13) & Chr(10), -1, vbBinaryCompare)
    
    info = s(1)
    msg = s(2)
    s3 = Split(info, ",", -1, vbBinaryCompare)
    s2 = Split(s3(0), " ", -1, vbBinaryCompare)
    msgnum = s2(1)
    msgnum = Right(msgnum, Len(msgnum) - 1)
    msgnum = Left(msgnum, Len(msgnum) - 1)
    'MsgBox msgnum & Chr(13) & Chr(10) & msg
    
'    x = Split(CStr(Date), "/", -1, vbBinaryCompare)
'    outFnamedt = App.Path & "\out\" & x(0) & ";" & x(1) & ";" & x(2) & " "
'    x = Split(CStr(Time), ":", -1, vbBinaryCompare)
'    outFnamedt = outFnamedt & x(0) & ";" & x(1) & ";" & x(2) & ".txt"
    Label6.Caption = "Message RECEIVED"
    
    ReplyNum = msgnum
    MyMSG = msg
    writeStr = ReplyNum & "$$" & MyMSG
    fnum = FreeFile
    
    Open App.Path & "\out\last.txt" For Output As fnum
    Print #fnum, writeStr
    Close fnum
    
'    fnum = FreeFile
'    Open outFnamedt For Append As fnum
'    Print #fnum, writeStr
'    Close fnum
    recvCnt = 0
Else
    recvCnt = 0
End If
End Sub

Private Sub Command2_Click()
If portOpen Then
    MSComm1.portOpen = False
End If


End

End Sub

Private Sub Command3_Click()
MSComm1.Output = "AT+CREG?" & Chr(13) & Chr(10)

End Sub

Private Sub Command4_Click()
MSComm1.Output = "AT+CSQ" & Chr(13) & Chr(10)

End Sub

Private Sub Command5_Click()
MSComm1.Output = "AT+CMGS=""" & TextMessageTo.Text & """" & Chr(13) & Chr(10)
MSComm1.Output = "06450631062D06280627" & TextMessage.Text & Chr(26)
End Sub

Private Sub Command6_Click()
MSComm1.Output = "AT+CMGS=""" & TextMessageTo.Text & """" & Chr(13) & Chr(10)
MSComm1.Output = "06450631062D06280627" & Chr(26)
End Sub

'Private Sub Command6_Click()
'MSComm1.Output = "AT+CSCA=""" & TextMsgCenter.Text & """" & Chr(13) & Chr(10)
'End Sub

Private Sub Command7_Click()
MSComm1.Output = "AT+CMGF=1" & Chr(13) & Chr(10)

End Sub

Private Sub Command8_Click()
MSComm1.Output = "AT+CNMI=1,2,0,0,0" & Chr(13) & Chr(10)

End Sub

Private Sub Command9_Click()
MSComm1.Output = "AT+CNMI=1,1,0,0,0" & Chr(13) & Chr(10)

End Sub

Private Sub Form_Load()
portOpen = False
Combo1.ListIndex = 0

End Sub

Private Sub MSComm1_OnComm()
Dim temp As String
If MSComm1.CommEvent = comEvReceive Then
    temp = MSComm1.Input
    Text1.Text = Text1.Text & temp
    Label4.Caption = recvCnt
    If initFlag = True Then
'        ReDim Preserve inArray(recvCnt)
        inArray(recvCnt) = temp
        recvCnt = recvCnt + 1
        waitCount = 0
    End If
End If
End Sub



Public Sub MySendMessage(sstr As String)
Dim x() As String, i As Integer, index As Integer


x = Split(sstr, "$$", -1, vbBinaryCompare)
TextMessageTo.Text = x(0)

Command5_Click
End Sub


Private Sub Timer1_Timer()
If waitCount < 21 Then waitCount = waitCount + 1
If initFlag = False Then
    If ((stat = nextStat) Or (waitCount > 15)) Then
        If (waitCount > 15) Then
            Label6.Caption = "Error In Communication."
            Label7.Caption = "- - -"
            Timer1.Enabled = False
            Exit Sub
        Else
            waitCount = 0
            Select Case stat
                Case 0:
                    MSComm1.Output = "AT" & Chr(13) & Chr(10)
                    Label6.Caption = "Initializing... AT"
                    nextStat = nextStat + 1
                Case 1:
                    MSComm1.Output = "AT+CREG?" & Chr(13) & Chr(10)
                    Label6.Caption = "Initializing... CHECK"
                    nextStat = nextStat + 1
                Case 2:
                    'MSComm1.Output = "AT+CSQ" & Chr(13) & Chr(10)
                    Label6.Caption = "Initializing... SIGNAL STRENGTH"
                    nextStat = nextStat + 1
                Case 3:
                    MSComm1.Output = "AT+CMGF=1" & Chr(13) & Chr(10)
                    Label6.Caption = "Initializing... SETTING TEXT FORMAT"
                    nextStat = nextStat + 1
                Case 4:
                    'MSComm1.Output = "AT+CSCA=""" & TextMsgCenter.Text & """" & Chr(13) & Chr(10)
                    Label6.Caption = "Initializing... MESSAGE CENTER NO."
                    nextStat = nextStat + 1
                Case 5:
                    MSComm1.Output = "AT+CNMI=1,2,0,0,0" & Chr(13) & Chr(10)
                    Label6.Caption = "Initializing... IMMEDIATE RESPONSE"
                    nextStat = nextStat + 1
                Case 6:
                    Label6.Caption = "DONE."
                    recvCnt = 0
                    nextStat = nextStat + 1
                    initFlag = True
                    waitCount = 16
                    portOpen = True

'                    Timer1.Enabled = False
            End Select
            Label7.Caption = stat & "/6"
        End If
        stat = stat + 1
    End If
Else
    If (waitCount = 5) And initFlag Then
        Command14_Click
    End If
End If

If initFlag Then
    Dim fname As String, fnum As String, myStr As String
    fname = App.Path & "\in.txt"
    If Dir$(fname) = "in.txt" Then
        Label6.Caption = "SENDING MESSAGE"
        fnum = FreeFile
        Open fname For Input As fnum
        Input #fnum, myStr
        Close fnum
        Kill fname
        If (LCase(myStr) = "exit") Then
         End
         Exit Sub
        End If
        MySendMessage myStr
    End If
End If
End Sub
