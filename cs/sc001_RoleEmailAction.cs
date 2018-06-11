using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Sitecore.Workflows.Simple;
using Sitecore.Data.Items;
using Sitecore.Diagnostics;
using System.Net.Mail;
using Sitecore.Diagnostics;

// In email workflow item:
// OLD: Sitecore.Workflows.Simple.EmailAction, Sitecore.Kernel
// NEW: Sitecore.Feature.Security.RoleEmailAction

//Obviously this item is far out of it's project and the namespace is not applicable to gh.
namespace Sitecore.Feature.Redacted
{
    public class RoleEmailAction
    {
        public void Process(WorkflowPipelineArgs args)
        {

            RLog("Custom log functional.");

            Assert.ArgumentNotNull((object)args, nameof(args));
            ProcessorItem processorItem = args.ProcessorItem;
            if (processorItem == null)
                return;
            Item innerItem = processorItem.InnerItem;
            string fullPath = innerItem.Paths.FullPath;
            string text1 = this.GetText(innerItem, "from", args);
            string text2 = this.GetText(innerItem, "to", args);
            //string text2 = "ryan.fleck@mnp.ca"; //DEBUG, priority one to send list of approvers to self.
            string text3 = this.GetText(innerItem, "mail server", args);
            string text4 = this.GetText(innerItem, "subject", args);
            string text5 = this.GetText(innerItem, "message", args);

            RLog("Incoming message data:"
                + "\r\n > text1 (from): " + text1
                + "\r\n > text2 (to): " + text2
                + "\r\n > text3 (server): " + text3
                + "\r\n > text4 (subject): " + text4
                + "\r\n > text5 (message): " + text5
                );


            Error.Assert(text2.Length > 0, "The 'To' field is not specified in the mail action item: " + fullPath);
            Error.Assert(text1.Length > 0, "The 'From' field is not specified in the mail action item: " + fullPath);
            Error.Assert(text4.Length > 0, "The 'Subject' field is not specified in the mail action item: " + fullPath);
            Error.Assert(text3.Length > 0, "The 'Mail server' field is not specified in the mail action item: " + fullPath);


            RLog("Sending email...");
            new SmtpClient(text3).Send(new MailMessage(text1, text2)
            {
                Subject = text4,
                Body = text5
            });
        }

        private string GetText(Item commandItem, string field, WorkflowPipelineArgs args)
        {
            string text = commandItem[field];
            if (text.Length > 0)
                return this.ReplaceVariables(text, args);
            return string.Empty;
        }

        private string ReplaceVariables(string text, WorkflowPipelineArgs args)
        {
            text = text.Replace("$itemPath$", args.DataItem.Paths.FullPath);
            text = text.Replace("$itemLanguage$", args.DataItem.Language.ToString());
            text = text.Replace("$itemVersion$", args.DataItem.Version.ToString());
            return text;
        }

        private void RLog(string text)
        {
            //Log to Sitecore.
            Diagnostics.Log.Debug("rcf - "+text);

            //Log to Troubleshooting file.
            using (StreamWriter w = File.AppendText(@"C:\inetpub\wwwroot\Sitecore\rcf-log.txt"))
            {
                w.WriteLine("\r\nRCF-LOG: {0}", text);
            }

        }


    }
}
