// Add to any class as a method for easy debugging.

private void RLog(string text)
{
    using (System.IO.StreamWriter w = System.IO.File.AppendText(@"C:\inetpub\wwwroot\Sitecore\rcf-log.txt"))
    {
        w.WriteLine("\r\n[{0} dbg] {1}", DateTime.Now.ToString("HH:mm:ss"), text);
        w.Close();
    }
}
